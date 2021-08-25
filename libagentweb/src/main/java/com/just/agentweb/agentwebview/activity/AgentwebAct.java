package com.just.agentweb.agentwebview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.AppUtils;
import com.just.agentweb.R;

public class AgentwebAct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agentwebview);

    }

    public void btn1(View view) {
        startActivity(new Intent(AppUtils.getAppPackageName() + ".hs.act.slbapp.BasicsDisplayWebActDemo"));
    }

    public void btn2(View view) {
        startActivity(new Intent(AppUtils.getAppPackageName() + ".hs.act.slbapp.SmartRefreshWebActDemo"));
    }

    public void btn3(View view) {
        startActivity(new Intent(AppUtils.getAppPackageName() + ".hs.act.slbapp.JsWebActDemo"));
    }

    public void btn4(View view) {
        startActivity(new Intent(AppUtils.getAppPackageName() + ".hs.act.slbapp.TablayouActDemo"));
    }

}
