package com.just.agentweb.agentwebview.activity;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.just.agentweb.R;

public class BasicsDisplayWebActDemo extends BaseActWebActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_basics_display_webview;
    }

    @Override
    protected void setup(@Nullable Bundle savedInstanceState) {
        super.setup(savedInstanceState);
    }

    @NonNull
    @Override
    protected ViewGroup getAgentWebParent() {
        return (ViewGroup) this.findViewById(R.id.ll_base_container111);
    }

    @Nullable
    @Override
    public String getUrl() {
        return "https://www.baidu.com";
    }
}
