package com.geek.liblanguage.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.geek.liblanguage.MultiLanguages;
import com.geek.liblanguage.R;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.hjq.toast.ToastUtils;
import java.util.Locale;

public final class LanguageAct extends LanguageBaseActivity
        implements RadioGroup.OnCheckedChangeListener, OnTitleBarListener {

    private TitleBar mTitleBar;
    private WebView mWebView;
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_language);

        mTitleBar = findViewById(R.id.tb_main_bar);
        mWebView = findViewById(R.id.wv_main_web);
        mRadioGroup = findViewById(R.id.rg_main_languages);

        mTitleBar.setOnTitleBarListener(this);

        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.loadUrl("https://developer.android.google.cn/index.html");

        ((TextView) findViewById(R.id.tv_main_language_activity)).setText(this.getResources().getString(R.string.current_language));
        ((TextView) findViewById(R.id.tv_main_language_application)).setText(getApplication().getResources().getString(R.string.current_language));
        ((TextView) findViewById(R.id.tv_main_language_system)).setText(MultiLanguages.getLanguageString(this, MultiLanguages.getSystemLanguage(), R.string.current_language));

        if (MultiLanguages.isSystemLanguage()) {
            mRadioGroup.check(R.id.rb_main_language_auto);
        } else {
            Locale locale = MultiLanguages.getAppLanguage();
            if (Locale.CHINA.equals(locale)) {
                mRadioGroup.check(R.id.rb_main_language_cn);
            } else if (Locale.TAIWAN.equals(locale)) {
                mRadioGroup.check(R.id.rb_main_language_tw);
            } else if (Locale.ENGLISH.equals(locale)) {
                mRadioGroup.check(R.id.rb_main_language_en);
            } else {
                mRadioGroup.check(R.id.rb_main_language_auto);
            }
        }

        mRadioGroup.setOnCheckedChangeListener(this);
    }

    /**
     * {@link RadioGroup.OnCheckedChangeListener}
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // ??????????????????
        boolean restart = false;

        if (checkedId == R.id.rb_main_language_auto) {
            // ????????????
            restart = MultiLanguages.setSystemLanguage(this);
        } else if (checkedId == R.id.rb_main_language_cn) {
            // ????????????
            restart = MultiLanguages.setAppLanguage(this, Locale.CHINA);
        } else if (checkedId == R.id.rb_main_language_tw) {
            // ????????????
            restart = MultiLanguages.setAppLanguage(this, Locale.TAIWAN);
        } else if (checkedId == R.id.rb_main_language_en) {
            // ??????
            restart = MultiLanguages.setAppLanguage(this, Locale.ENGLISH);
        }

        if (restart) {
            // 1.??????recreate?????????Activity?????????????????????????????????
            // recreate();

            // 2.????????????startActivity?????????Activity?????????????????????????????????????????????recreate?????????????????????????????????????????????????????????
            // startActivity(new Intent(this, LanguageActivity.class));
            // finish();

            // 3.???????????????????????? Activity ???????????????????????????????????????????????????????????????????????????????????????????????????????????????
            startActivity(new Intent(this, LanguageAct.class));
            overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            finish();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mWebView.onResume();
        mWebView.resumeTimers();
    }

    @Override
    public void onPause() {
        super.onPause();
        mWebView.onPause();
        mWebView.pauseTimers();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //??????????????????
        mWebView.clearHistory();
        //????????????
        mWebView.stopLoading();
        //?????????????????????
        mWebView.loadUrl("about:blank");
        mWebView.setWebChromeClient(null);
        mWebView.setWebViewClient(null);
        //??????WebView?????????View??????
        mWebView.removeAllViews();
        //????????????WebView???????????????
        mWebView.destroy();
    }

    @Override
    public void onLeftClick(View view) {}

    @Override
    public void onTitleClick(View view) {
        ToastUtils.show(R.string.app_name);
    }

    @Override
    public void onRightClick(View view) {}
}