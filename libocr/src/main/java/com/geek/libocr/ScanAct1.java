package com.geek.libocr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.geek.libocr.base.ScannerUtils;


public class ScanAct1 extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_act1);
        tv = findViewById(R.id.tv);
    }

    public void onClickBtn(View v) {
        Intent intent = new Intent(this, ScannerAct2.class);
        startActivity(intent);
    }

    public void onClickBtn2(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                String path = getExternalFilesDir("image").getAbsolutePath() + "/a.jpg";
//                String s = ScannerUtils.decodeText(path);
//                BankCardInfoBean b = ScannerUtils.getBankCardInfo("6222600260001072444");
//                String s = b == null ? null : b.toString();
                String path = getExternalFilesDir("image").getAbsolutePath() + "/a.png";
                final String s = ScannerUtils.decodeText(path);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText("result=" + s);
                    }
                });
            }
        }).start();
    }

}
