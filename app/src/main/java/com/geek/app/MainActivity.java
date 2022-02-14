package com.geek.app;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.SPUtils;
import com.example.slbyanzheng.ZhiwenActtivity;
import com.example.slbyanzheng.slide.SlideAct1;
import com.geek.libbase.base.SlbBaseActivity;
import com.geek.libbase.fenlei.FenleiAct;
import com.geek.libbase.splshact.SplshActDemo;
import com.geek.libutils.app.MyLogUtil;
import com.geek.tablayout.SlidingTabActivity;
import com.geek.tablayout.TablayoutAct;
import com.just.agentweb.geek.fragment.AgentWebFragment;
import com.just.agentweb.geek.hois3.HiosHelperNew;
import com.lib.lock.fingerprint.core.MyListener;
import com.lib.lock.fingerprint.utils.FingerprintUtil;
import com.lib.lock.gesture.content.SPManager;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.OnInputConfirmListener;
import com.pgyer.pgyersdk.PgyerSDKManager;


public class MainActivity extends SlbBaseActivity {

    private TextView tv2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        FingerprintUtil.startFingerprintRecognition(MainActivity.this, new MyListener() {
//            @Override
//            public void onAuthenticateSuccess() {
//                MyLogUtil.e("FingerprintUtil", "onAuthenticateSuccess");
////                finish();
////                getWindow().getDecorView().postDelayed(new Runnable() {
////                    @Override
////                    public void run() {
////                        onLoginSuccess(AppUtils.getAppPackageName() + ".hs.act.slbapp.MainActivity2");
////                    }
////                }, 3000);
//                onLoginSuccess(AppUtils.getAppPackageName() + ".hs.act.slbapp.MainActivity2");
//            }
//
//            @Override
//            public void onAuthenticateFailed(int helpId, String errString) {
//                String aaaa = "";
//                MyLogUtil.e("FingerprintUtil", errString + "");
//            }
//
//            @Override
//            public void onAuthenticateError(int errMsgId) {
//                String aaaa = "";
//                MyLogUtil.e("FingerprintUtil", errMsgId + "");
//            }
//
//            @Override
//            public void onStartAuthenticateResult(boolean isSuccess) {
//                String aaaa = "";
//                MyLogUtil.e("FingerprintUtil", isSuccess + "");
//            }
//        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setup(@Nullable Bundle savedInstanceState) {
        super.setup(savedInstanceState);
        HiosHelperNew.config(AppUtils.getAppPackageName() + ".web.page3.js3");
        PgyerSDKManager.checkSoftwareUpdate(this);
        tv2 = findViewById(R.id.tv2);
        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, DemoUpdateAppMainActivity.class));
                startActivity(new Intent(MainActivity.this, SlideAct1.class));
//                HiosHelperNew.resolveAd(MainActivity.this, MainActivity.this, "http://www.baidu.com/?condition=login");
//                HiosHelperNew.resolveAd(MainActivity.this, MainActivity.this, "http://www.baidu.com/");
//                HiosHelperNew.resolveAd(MainActivity.this, MainActivity.this, "http://v.dtdjzx.gov.cn/voice/");

            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, TablayoutAct.class));
                Intent intent = new Intent(AppUtils.getAppPackageName() + ".web.page3.js3");
                intent.putExtra(AgentWebFragment.URL_KEY, "http://192.168.2.247:9528/ruralList/ruralHome");
//                intent.putExtra(AgentWebFragment.URL_KEY, "http://v.dtdjzx.gov.cn/voice/");
                startActivity(intent);
//                HiosHelperNew.resolveAd(MainActivity.this, MainActivity.this, "dataability://" + AppUtils.getAppPackageName() + ".hs.act.slbapp.WebActivity{act}?" + AgentWebFragment.URL_KEY + "={s}");


            }
        });
        //
        if (FingerprintUtil.supportAndSysOpenedFingerPrint() &&
                SPManager.getInstance().getHasFingerPrint()) {
            tv2.setText("验证指纹密码");
        } else {
            tv2.setText("开启指纹密码");
        }
//        getWindow().getDecorView().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                FingerprintUtil.startFingerprintRecognition(MainActivity.this, new MyListener() {
//                    @Override
//                    public void onAuthenticateSuccess() {
//                        MyLogUtil.e("FingerprintUtil", "onAuthenticateSuccess");
////                finish();
////                getWindow().getDecorView().postDelayed(new Runnable() {
////                    @Override
////                    public void run() {
////                        onLoginSuccess(AppUtils.getAppPackageName() + ".hs.act.slbapp.MainActivity2");
////                    }
////                }, 3000);
////                        onLoginSuccess(AppUtils.getAppPackageName() + ".hs.act.slbapp.MainActivity2");
//                    }
//
//                    @Override
//                    public void onAuthenticateFailed(int helpId, String errString) {
//                        String aaaa = "";
//                        MyLogUtil.e("FingerprintUtil", errString + "");
//                    }
//
//                    @Override
//                    public void onAuthenticateError(int errMsgId) {
//                        String aaaa = "";
//                        MyLogUtil.e("FingerprintUtil", errMsgId + "");
//                    }
//
//                    @Override
//                    public void onStartAuthenticateResult(boolean isSuccess) {
//                        String aaaa = "";
//                        MyLogUtil.e("FingerprintUtil", isSuccess + "");
//                    }
//                });
//            }
//        }, 0);
    }
}