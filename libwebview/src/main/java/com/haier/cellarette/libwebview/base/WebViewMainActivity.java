package com.haier.cellarette.libwebview.base;

import android.os.Bundle;
import android.text.TextUtils;

public class WebViewMainActivity extends WebViewActivity {

    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String adId = getIntent().getStringExtra("aid");
        if (TextUtils.isEmpty(adId)) {
            finish();
            return;
        }
        if (adId.equals("1")) {
            url = "https://www.iqiyi.com/";
        } else {
            url = "http://www.baidu.com/?condition=login/";
        }
//        setup();//必须删除bufen
//        mPresenter = PresenterHelper.create(AdPresenter.class, this);
//        mPresenter.getAdUrlById(adId);

        loadUrl(url);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
