package com.geek.app;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.geek.libbase.base.SlbBaseActivity;
import com.lib.lock.fingerprint.utils.FingerprintUtil;


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
        FingerprintUtil.startFingerprintRecognition(this, null);

    }
}