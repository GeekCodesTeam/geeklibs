package com.geek.app;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.geek.libbase.base.SlbBaseActivity;


public class MainActivity2 extends SlbBaseActivity {


//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//        FingerprintUtil.startFingerprintRecognition(this, null);
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void setup(@Nullable Bundle savedInstanceState) {
        super.setup(savedInstanceState);
//        FingerprintUtil.startFingerprintRecognition(this, null);
//        FingerprintUtil.startFingerprintRecognition(MainActivity2.this, new MyListener() {
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
//                startActivity(new Intent(MainActivity2.this, ZhiwenActtivity.class));
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
}