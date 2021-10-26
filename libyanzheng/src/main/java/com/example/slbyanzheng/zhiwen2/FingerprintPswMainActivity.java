package com.example.slbyanzheng.zhiwen2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.slbyanzheng.R;
import com.lib.lock.fingerprint.core.FingerprintCore;
import com.lib.lock.fingerprint.core.IFingerprintResultListener;


/**
 * 作者：xin on 2018/7/9 0009 15:03
 * <p>
 * 邮箱：ittfxin@126.com
 * <p>
 * https://github.com/wzx54321/XinFrameworkLib
 */

public class FingerprintPswMainActivity extends AppCompatActivity {


    public static void Launcher(Context context) {

        Intent intent = new Intent(context, FingerprintPswMainActivity.class);

        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fingerprint_psw_main);

        FingerprintCore.getInstance().setFingerprintManager(new IFingerprintResultListener() {
            @Override
            public void onAuthenticateSuccess() {
                Toast.makeText(getApplicationContext(),"指纹识别成功",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAuthenticateFailed(int helpId,String msg) {
                Toast.makeText(getApplicationContext(),"指纹识别失败，请重试！",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAuthenticateError(int errMsgId) {
                Toast.makeText(getApplicationContext(),"指纹识别错误，等待几秒之后再重试",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartAuthenticateResult(boolean isSuccess) {

            }
        });

        startFingerprintRecognition();
    }


    /**
     * 开始指纹识别
     */
    private void startFingerprintRecognition() {


        if (FingerprintCore.getInstance().isAuthenticating()) {
            Toast.makeText(this, "指纹识别已经开启，长按指纹解锁键", Toast.LENGTH_LONG).show();
        } else {
            FingerprintCore.getInstance().startAuthenticate();
        }
    }


    /**
     * 取消指纹识别
     */
    private void cancelFingerprintRecognition() {
        if (FingerprintCore.getInstance().isAuthenticating()) {
            FingerprintCore.getInstance().cancelAuthenticate();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        FingerprintCore.getInstance().cancelAuthenticate();
        FingerprintCore.getInstance().setFingerprintManager(null);
    }
}
