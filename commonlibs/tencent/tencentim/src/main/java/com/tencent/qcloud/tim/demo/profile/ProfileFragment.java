package com.tencent.qcloud.tim.demo.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.libutils.app.BaseApp;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tim.demo.BaseActivity;

import com.tencent.qcloud.tim.demo.R;
import com.tencent.qcloud.tim.uikit.TUIKit;
import com.tencent.qcloud.tim.uikit.base.BaseFragment;
import com.tencent.qcloud.tim.uikit.base.IUIKitCallBack;
import com.tencent.qcloud.tim.uikit.component.dialog.TUIKitDialog;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;


public class ProfileFragment extends BaseFragment {

    private View mBaseView;
    private ProfileLayout mProfileLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        mBaseView = inflater.inflate(R.layout.profile_fragment, container, false);
        initView();
        return mBaseView;
    }

    private void initView() {
        mProfileLayout = mBaseView.findViewById(R.id.profile_view);
        mBaseView.findViewById(R.id.logout_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TUIKitDialog(getActivity())
                        .builder()
                        .setCancelable(true)
                        .setCancelOutside(true)
                        .setTitle(getString(R.string.logout_tip))
                        .setDialogWidth(0.75f)
                        .setPositiveButton(getString(R.string.sure), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                TUIKit.logout(new IUIKitCallBack() {

                                    @Override
                                    public void onSuccess(Object data) {
                                        logout();
                                    }

                                    @Override
                                    public void onError(String module, int errCode, String errMsg) {
                                        ToastUtil.toastLongMessage("logout fail: " + errCode + "=" + errMsg);
                                        logout();
                                    }

                                    private void logout() {
                                        BaseActivity.logout(BaseApp.get());
                                        if (getActivity() != null) {
                                            getActivity().finish();
                                        }
                                    }
                                } );
                            }
                        })
                        .setNegativeButton(getString(R.string.cancel), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .show();

            }
        });

    }
}
