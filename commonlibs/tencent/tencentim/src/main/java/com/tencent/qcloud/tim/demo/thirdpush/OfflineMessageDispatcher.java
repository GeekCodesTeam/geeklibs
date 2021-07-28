package com.tencent.qcloud.tim.demo.thirdpush;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;

import com.tencent.qcloud.tim.demo.utils.TencentApp;
import com.google.gson.Gson;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMSignalingInfo;
import com.tencent.liteav.model.CallModel;
import com.tencent.liteav.model.TRTCAVCallImpl;

import com.tencent.qcloud.tim.demo.R;
import com.tencent.qcloud.tim.demo.chat.ChatActivity;
import com.tencent.qcloud.tim.demo.main.IMMainActivity;
import com.tencent.qcloud.tim.demo.utils.BrandUtil;
import com.tencent.qcloud.tim.demo.utils.Constants;
import com.tencent.qcloud.tim.demo.utils.DemoLog;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.modules.chat.base.OfflineMessageBean;
import com.tencent.qcloud.tim.uikit.modules.chat.base.OfflineMessageContainerBean;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageHelper;

import java.util.Map;
import java.util.Set;

public class OfflineMessageDispatcher {

    private static final String TAG = OfflineMessageDispatcher.class.getSimpleName();

    public static OfflineMessageBean parseOfflineMessage(Intent intent) {
        DemoLog.i(TAG, "intent: " + intent);
        if (intent == null) {
            return null;
        }
        Bundle bundle = intent.getExtras();
        DemoLog.i(TAG, "bundle: " + bundle);
        if (bundle == null) {
            String ext = VIVOPushMessageReceiverImpl.getParams();
            if (!TextUtils.isEmpty(ext)) {
                return getOfflineMessageBeanFromContainer(ext);
            }
            return null;
        } else {
            String ext = bundle.getString("ext");
            DemoLog.i(TAG, "push custom data ext: " + ext);
            if (TextUtils.isEmpty(ext)) {
                if (BrandUtil.isBrandXiaoMi()) {
                    ext = getXiaomiMessage(bundle);
                    return getOfflineMessageBeanFromContainer(ext);
                } else if (BrandUtil.isBrandOppo()) {
                    ext = getOPPOMessage(bundle);
                    return getOfflineMessageBean(ext);
                }
            } else {
                return getOfflineMessageBeanFromContainer(ext);
            }
            return null;
        }
    }

    private static String getXiaomiMessage(Bundle bundle) {
        MiPushMessage miPushMessage = (MiPushMessage) bundle.getSerializable(PushMessageHelper.KEY_MESSAGE);
        if (miPushMessage == null) {
            return null;
        }
        Map extra = miPushMessage.getExtra();
        return extra.get("ext").toString();
    }

    private static String getOPPOMessage(Bundle bundle) {
        Set<String> set = bundle.keySet();
        if (set != null) {
            for (String key : set) {
                Object value = bundle.get(key);
                DemoLog.i(TAG, "push custom data key: " + key + " value: " + value);
                if (TextUtils.equals("entity", key)) {
                    return value.toString();
                }
            }
        }
        return null;
    }

    private static OfflineMessageBean getOfflineMessageBeanFromContainer(String ext) {
        if (TextUtils.isEmpty(ext)) {
            return null;
        }
        OfflineMessageContainerBean bean = null;
        try {
            bean = new Gson().fromJson(ext, OfflineMessageContainerBean.class);
        } catch (Exception e) {
            DemoLog.w(TAG, "getOfflineMessageBeanFromContainer: " + e.getMessage());
        }
        if (bean == null) {
            return null;
        }
        return offlineMessageBeanValidCheck(bean.entity);
    }

    private static OfflineMessageBean getOfflineMessageBean(String ext) {
        if (TextUtils.isEmpty(ext)) {
            return null;
        }
        OfflineMessageBean bean = new Gson().fromJson(ext, OfflineMessageBean.class);
        return offlineMessageBeanValidCheck(bean);
    }

    private static OfflineMessageBean offlineMessageBeanValidCheck(OfflineMessageBean bean) {
        if (bean == null) {
            return null;
        } else if (bean.version != 1
                || (bean.action != OfflineMessageBean.REDIRECT_ACTION_CHAT
                    && bean.action != OfflineMessageBean.REDIRECT_ACTION_CALL) ) {
            PackageManager packageManager = TencentApp.get().getPackageManager();
            String label = String.valueOf(packageManager.getApplicationLabel(TencentApp.get().getApplicationInfo()));
            ToastUtil.toastLongMessage(TencentApp.get().getString(R.string.you_app) + label + TencentApp.get().getString(R.string.low_version));
            DemoLog.e(TAG, "unknown version: " + bean.version + " or action: " + bean.action);
            return null;
        }
        return bean;
    }

    public static boolean redirect(final OfflineMessageBean bean) {
        if (bean.action == OfflineMessageBean.REDIRECT_ACTION_CHAT) {
            ChatInfo chatInfo = new ChatInfo();
            chatInfo.setType(bean.chatType);
            chatInfo.setId(bean.sender);
            Intent intent = new Intent(TencentApp.get(), ChatActivity.class);
            intent.putExtra(Constants.CHAT_INFO, chatInfo);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            TencentApp.get().startActivity(intent);
            return true;
        } else if (bean.action == OfflineMessageBean.REDIRECT_ACTION_CALL) {
            final CallModel model = new Gson().fromJson(bean.content, CallModel.class);
            DemoLog.i(TAG, "bean: "+ bean + " model: " + model);
            if (model != null) {
                long timeout = V2TIMManager.getInstance().getServerTime() - bean.sendTime;
                if (timeout >= model.timeout) {
                    ToastUtil.toastLongMessage(TencentApp.get().getString(R.string.call_time_out));
                } else {
                    if (TextUtils.isEmpty(model.groupId)) {
                        if (bean.chatType == V2TIMConversation.V2TIM_C2C) {
                            // c2c 登录之后会同步消息，所以不需要主动调用通话界面
                        } else {
                            DemoLog.e(TAG, "group call but no group id");
                        }
                    } else {
                        V2TIMSignalingInfo info = new V2TIMSignalingInfo();
                        info.setInviteID(model.callId);
                        info.setInviteeList(model.invitedList);
                        info.setGroupID(model.groupId);
                        info.setInviter(bean.sender);
                        V2TIMManager.getSignalingManager().addInvitedSignaling(info, new V2TIMCallback() {

                            @Override
                            public void onError(int code, String desc) {
                                DemoLog.e(TAG, "addInvitedSignaling code: " + code + " desc: " + desc);
                            }

                            @Override
                            public void onSuccess() {
                                ((TRTCAVCallImpl)(TRTCAVCallImpl.sharedInstance(TencentApp.get()))).
                                        processInvite(model.callId, bean.sender, model.groupId, model.invitedList, bean.content);
                            }
                        });
                        return true;
                    }
                }
            }
        }
        Intent intent = new Intent(TencentApp.get(), IMMainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        TencentApp.get().startActivity(intent);
        return true;
    }
}
