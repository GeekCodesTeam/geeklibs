package com.geek.liblanguage.demo;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.geek.liblanguage.MultiLanguages;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/MultiLanguages
 *    time   : 2019/08/10
 *    desc   : Activity 基类
 */
public abstract class LanguageBaseActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        // 绑定语种
        super.attachBaseContext(MultiLanguages.attach(newBase));
    }
}