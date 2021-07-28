package com.tencent.qcloud.tim.demo.thirdpush;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.tencent.qcloud.tim.demo.utils.TencentApp;
import com.tencent.qcloud.tim.demo.SplashActivity;
import com.tencent.qcloud.tim.demo.utils.DemoLog;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;

import java.util.List;
import java.util.Map;


public class XiaomiMsgReceiver extends PushMessageReceiver {

    private static final String TAG = XiaomiMsgReceiver.class.getSimpleName();
    private String mRegId;

    @Override
    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        DemoLog.d(TAG, "onReceivePassThroughMessage is called. ");
    }

    @Override
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        DemoLog.d(TAG, "onNotificationMessageClicked miPushMessage " + miPushMessage.toString());
        Map<String, String> extra = miPushMessage.getExtra();
        String ext = extra.get("ext");
        if (TextUtils.isEmpty(ext)) {
            DemoLog.w(TAG, "onNotificationMessageClicked: no extra data found");
            return;
        }
        Intent intent = new Intent(TencentApp.get(), SplashActivity.class);
        intent.putExtra("ext", ext);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        TencentApp.get().startActivity(intent);
    }

    @Override
    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        DemoLog.d(TAG, "onNotificationMessageArrived is called. ");
    }

    @Override
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        DemoLog.d(TAG, "onReceiveRegisterResult is called. " + miPushCommandMessage.toString());
        String command = miPushCommandMessage.getCommand();
        List<String> arguments = miPushCommandMessage.getCommandArguments();
        String cmdArg1 = ((arguments != null && arguments.size() > 0) ? arguments.get(0) : null);

        DemoLog.d(TAG, "cmd: " + command + " | arg: " + cmdArg1
                + " | result: " + miPushCommandMessage.getResultCode() + " | reason: " + miPushCommandMessage.getReason());

        if (MiPushClient.COMMAND_REGISTER.equals(command)) {
            if (miPushCommandMessage.getResultCode() == ErrorCode.SUCCESS) {
                mRegId = cmdArg1;
            }
        }

        DemoLog.d(TAG, "regId: " + mRegId);
        ThirdPushTokenMgr.getInstance().setThirdPushToken(mRegId);
        ThirdPushTokenMgr.getInstance().setPushTokenToTIM();
    }

    @Override
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        super.onCommandResult(context, miPushCommandMessage);
    }
}
