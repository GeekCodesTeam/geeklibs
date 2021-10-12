package com.geek.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.AppUtils;
import com.haier.cellarette.baselibrary.recycleviewcard.RCardAct;
import com.just.agentweb.geek.activity.AgentwebAct;
import com.just.agentweb.geek.fragment.AgentWebFragment;
import com.just.agentweb.geek.hois3.HiosHelperNew;

import xyz.doikki.dkplayer.activity.DKMainActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HiosHelperNew.config(AppUtils.getAppPackageName() + ".web.page3.js3");
        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RCardAct.class));
//                HiosHelperNew.resolveAd(MainActivity.this, MainActivity.this, "http://www.baidu.com/?condition=login");
//                HiosHelperNew.resolveAd(MainActivity.this, MainActivity.this, "http://www.baidu.com/");
//                HiosHelperNew.resolveAd(MainActivity.this, MainActivity.this, "http://v.dtdjzx.gov.cn/voice/");

            }
        });
        findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DKMainActivity.class));
//                HiosHelperNew.resolveAd(MainActivity.this, MainActivity.this, "dataability://" + AppUtils.getAppPackageName() + ".hs.act.slbapp.WebActivity{act}?" + AgentWebFragment.URL_KEY + "={s}");
            }
        });
    }
}