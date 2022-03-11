package com.geek.app;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import android.content.Intent;
import android.graphics.drawable.PictureDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.AppUtils;
import com.geek.libbase.base.SlbBaseActivity;
import com.geek.libglide47.base.progress.GlideApp;
import com.geek.libglide47.base.svg.SvgSoftwareLayerSetter;
import com.geek.libocr.ScanAct1;
import com.just.agentweb.geek.fragment.AgentWebFragment;
import com.just.agentweb.geek.hois3.HiosHelperNew;
import com.lib.lock.fingerprint.utils.FingerprintUtil;
import com.lib.lock.gesture.content.SPManager;
import com.pgyer.pgyersdk.PgyerSDKManager;


public class MainActivity extends SlbBaseActivity {

    private TextView tv2;
    private ImageView iv1;

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
//        HiosHelperNew.config(AppUtils.getAppPackageName() + ".web.page3.js3");
        HiosHelperNew.config(AppUtils.getAppPackageName() + ".web.page3");
        PgyerSDKManager.checkSoftwareUpdate(this);
        tv2 = findViewById(R.id.tv2);
        iv1 = findViewById(R.id.iv1);
        GlideApp.with(this).as(PictureDrawable.class)
                .transition(withCrossFade())
                .listener(new SvgSoftwareLayerSetter())
                .load("http://www.clker.com/cliparts/u/Z/2/b/a/6/android-toy-h.svg").into(iv1);
//                .load("https://s2.51cto.com//wyfs02/M01/89/BA/wKioL1ga-u7QnnVnAAAfrCiGnBQ946_middle.jpg").into(iv1);
        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, DemoUpdateAppMainActivity.class));
//                startActivity(new Intent(MainActivity.this, SlideAct1.class));
//                startActivity(new Intent(MainActivity.this, HIOSAct1.class));
                startActivity(new Intent(MainActivity.this, ScanAct1.class));
//                HiosHelperNew.resolveAd(MainActivity.this, MainActivity.this, "http://www.baidu.com/?condition=login");
//                HiosHelperNew.resolveAd(MainActivity.this, MainActivity.this, "http://www.baidu.com/");
//                HiosHelperNew.resolveAd(MainActivity.this, MainActivity.this, "http://t-nv-app.xczx-jn.com/#/dashboard");//
                try {
//                    Log.v(TAG, "root Runtime->reboot");
                    Process proc = Runtime.getRuntime().exec(new String[]{"su", "-c", "reboot "});  //关机
                    proc.waitFor();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//                Intent intent2 = new Intent(Intent.ACTION_REBOOT);
//                intent2.putExtra("nowait", 1);
//                intent2.putExtra("interval", 1);
//                intent2.putExtra("window", 0);
//                sendBroadcast(intent2);
//                PowerManager pManager=(PowerManager) getSystemService(Context.POWER_SERVICE);
//                pManager.reboot(null);//重启
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, TablayoutAct.class));
                Intent intent = new Intent(AppUtils.getAppPackageName() + ".web.page3.js3");
//                intent.putExtra(AgentWebFragment.URL_KEY, "http://t-nv-app.xczx-jn.com/#/dashboard");
                intent.putExtra(AgentWebFragment.URL_KEY, "http://v.dtdjzx.gov.cn/voice/");
                startActivity(intent);
//                HiosHelperNew.resolveAd(MainActivity.this, MainActivity.this, "dataability://" + AppUtils.getAppPackageName() + ".hs.act.slbapp.SlideAct1{act}?" + AgentWebFragment.URL_KEY + "={s}");


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