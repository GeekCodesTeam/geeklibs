package com.geek.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.AppUtils;
import com.geek.libbase.base.SlbBaseActivity;
import com.github.commonlibs.libupdateapputilsold.DemoUpdateAppMainActivity;
import com.just.agentweb.geek.hois3.HiosHelperNew;
import com.lxj.xpopupdemo.XpopupMainActivity;

import xyz.doikki.dkplayer.activity.DKMainActivity;


public class MainActivity extends SlbBaseActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setup(@Nullable Bundle savedInstanceState) {
        super.setup(savedInstanceState);
        HiosHelperNew.config(AppUtils.getAppPackageName() + ".web.page3.js3");
        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DemoUpdateAppMainActivity.class));
//                HiosHelperNew.resolveAd(MainActivity.this, MainActivity.this, "http://www.baidu.com/?condition=login");
//                HiosHelperNew.resolveAd(MainActivity.this, MainActivity.this, "http://www.baidu.com/");
//                HiosHelperNew.resolveAd(MainActivity.this, MainActivity.this, "http://v.dtdjzx.gov.cn/voice/");

            }
        });
        findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, XpopupMainActivity.class));
//                HiosHelperNew.resolveAd(MainActivity.this, MainActivity.this, "dataability://" + AppUtils.getAppPackageName() + ".hs.act.slbapp.WebActivity{act}?" + AgentWebFragment.URL_KEY + "={s}");
            }
        });
    }
}