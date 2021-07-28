/*
 * Copyright (C) 2018 Jenly Yu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.slbappcomm.saoma.demo1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.slbappcomm.R;
import com.google.zxing.BarcodeFormat;
import com.king.zxing.util.CodeUtils;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public class CodeActivity extends AppCompatActivity {

    private TextView tvTitle;
    private ImageView ivCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saoma1_code_activity);
        ivCode = findViewById(R.id.ivCode);
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText(getIntent().getStringExtra(SaomaAct.KEY_TITLE));
        boolean isQRCode = getIntent().getBooleanExtra(SaomaAct.KEY_IS_QR_CODE,false);

        if(isQRCode){
            createQRCode(getString(R.string.app_nameslbappcomm));
        }else{
            createBarCode("1234567890");
        }
    }

    /**
     * 生成二维码
     * @param content
     */
    private void createQRCode(final String content){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //生成二维码相关放在子线程里面
                Bitmap logo = BitmapFactory.decodeResource(getResources(),R.drawable.icon_dh1);
                final Bitmap bitmap =  CodeUtils.createQRCode(content,600,logo);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //显示二维码
                        ivCode.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }

    /**
     * 生成条形码
     * @param content
     */
    private void createBarCode(final String content){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //生成条形码相关放在子线程里面
                final Bitmap bitmap = CodeUtils.createBarCode(content, BarcodeFormat.CODE_128,800,200,null,true);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //显示二维码
                        ivCode.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }

    public void onClick(View v){
        if (v.getId() == R.id.ivLeft) {
            onBackPressed();
        }
    }
}