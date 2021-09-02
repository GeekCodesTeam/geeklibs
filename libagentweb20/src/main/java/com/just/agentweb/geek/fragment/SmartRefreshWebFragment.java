package com.just.agentweb.geek.fragment;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;

import com.just.agentweb.IWebLayout;
import com.just.agentweb.geek.R;
import com.just.agentweb.geek.widget.SmartRefreshWebLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
//import com.scwang.smartrefresh.layout.SmartRefreshLayout;
//import com.scwang.smartrefresh.layout.api.RefreshLayout;
//import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created by cenxiaozhong on 2017/7/1.
 * source code  https://github.com/Justson/AgentWeb
 */

public class SmartRefreshWebFragment extends BounceWebFragment {

    public static SmartRefreshWebFragment getInstance(Bundle bundle) {

        SmartRefreshWebFragment mSmartRefreshWebFragment = new SmartRefreshWebFragment();
        if (mSmartRefreshWebFragment != null) {
            mSmartRefreshWebFragment.setArguments(bundle);
        }

        return mSmartRefreshWebFragment;
    }

    private SmartRefreshWebLayout mSmartRefreshWebLayout = null;

    @Override
    public String getUrl() {
        return super.getUrl();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_agentweb_smart, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final SmartRefreshLayout mSmartRefreshLayout = (SmartRefreshLayout) this.mSmartRefreshWebLayout.getLayout();

        final WebView mWebView = this.mSmartRefreshWebLayout.getWebView();
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mAgentWeb.getUrlLoader().reload();

                mSmartRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSmartRefreshLayout.finishRefresh();
                    }
                }, 2000);
            }
        });
        mSmartRefreshLayout.autoRefresh();


    }

//    @Override
//    protected void getJsInterface() {
//        if (mAgentWeb != null) {
//            //注入对象
//            mAgentWeb.getJsInterfaceHolder().addJavaObject("android", new ShouyeInterface(mAgentWeb, getActivity()));
//        }
//        super.getJsInterface();
//    }


    @Override
    protected IWebLayout getWebLayout() {
        return this.mSmartRefreshWebLayout = new SmartRefreshWebLayout(this.getActivity());
    }


    @Override
    protected void addBGChild(FrameLayout frameLayout) {

        frameLayout.setBackgroundColor(Color.TRANSPARENT);

    }


}
