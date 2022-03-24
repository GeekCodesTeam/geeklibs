package com.geek.libwebview;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.AppUtils;
import com.geek.libbase.R;
import com.geek.libwebview.hioscommon.HiosRegister;
import com.geek.libwebview.hois2.HiosHelper;


/**
 * Java数据类型	query_string标识符
 * boolean	           {b}
 * byte	               {y}
 * short	           {o}
 * int	               {i}
 * long	               {l}
 * float	           {f}
 * double	           {d}
 * String	           {s}
 */
public class DemoWebviewMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewmain);
        configHios();
        String change1 = "change1";
        init();
    }

    private void configHios() {
        HiosRegister.load();
        HiosHelper.config(AppUtils.getAppPackageName() + ".ad.web.page", AppUtils.getAppPackageName() + ".web.page");

        // 接收部分
        // private int mAction; // default 0
        // private String mSkuId; // maybe null
        // private String mCategoryId;
        // mAction = getIntent().getIntExtra("act", 0);
        // mSkuId = getIntent().getStringExtra("sku_id");
        // mCategoryId = getIntent().getStringExtra("category_id");

        // APPLINLK
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("app://cs.znclass.com/com.sdzn.fzx.teacher.hs.act.XqfxActivity?show=" + "1"));
//        startActivity(intent);
        // 接收部分2
        // ATTENTION: This was auto-generated to handle app links.
//        Intent appLinkIntent = getIntent();
//        if (appLinkIntent != null) {
//            String appLinkAction = appLinkIntent.getAction();
//            if (appLinkAction != null) {
//                Uri appLinkData = appLinkIntent.getData();
//                if (appLinkData != null) {
//                    String aaaa = appLinkData.getQueryParameter("query1");
//                    String bbbb = appLinkData.getQueryParameter("query2");
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("app://cs.znclass.com/" + AppUtils.getAppPackageName() + ".hs.act.loginactivity?query1=" + aaaa + "&query2=" + bbbb));
//                    startActivity(intent);
//                }
//            }
//        }

    }

    private void init() {
        findViewById(R.id.tv01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 普通的Activity包名HiosRegister跳转
                // action跳转
                // hios://jump.HiosMainActivity
                // action跳转带参数
                // hios://jump.HiosMainActivity?skuId={s}value&category_id={s}category_id_value
                // action跳转带参数并且弹出窗
                // hios://jump.HiosMainActivity?act={i}1&sku_id={s}value&category_id={s}category_id_value&playing={b}false
                // value为商品的Activity包名sku_id    category_id_value为分类Activity包名category_id
                HiosHelper.resolveAd(DemoWebviewMainActivity.this, DemoWebviewMainActivity.this, "hios://jump.HiosMainActivity?act={i}1&sku_id={s}2&category_id={s}3");
            }
        });
        findViewById(R.id.tv11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 普通的Activity包名未HiosRegister跳转
                // action跳转
                // hios://activity.NoHiosMainActivity
                // action跳转带参数
                // hios://activity.NoHiosMainActivity?skuId={s}value&category_id={s}category_id_value
                // action跳转带参数并且弹出窗
                // hios://activity.NoHiosMainActivity?act={i}1&sku_id={s}value&category_id={s}category_id_value&playing={b}false
                // value为商品的Activity包名sku_id    category_id_value为分类Activity包名category_id
                // hios://activity.NoHiosMainActivity?act={i}1&sku_id={s}341703311759500256
//                HiosHelper.resolveAd(DemoWebviewMainActivity.this, DemoWebviewMainActivity.this, "hios://.activity.NoHiosMainActivity?act={i}1&sku_id={s}2a&category_id={s}3a");
                HiosHelper.resolveAd(DemoWebviewMainActivity.this, DemoWebviewMainActivity.this, "hios://activity.NoHiosMainActivity?act={i}1&sku_id={s}2a&category_id={s}3a");
            }
        });
        findViewById(R.id.tv21).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 普通的ActivityAction跳转
                // hios://hs.ac.NoHiosMainActivity{act}                                                                 action跳转
                // hios://hs.ac.NoHiosMainActivity{act}skuId={s}value&category_id={s}category_id_value                  action跳转带参数
                // hios://hs.ac.NoHiosMainActivity{act}?act={i}1&sku_id={s}value&category_id={s}category_id_value       action跳转带参数并且弹出窗
                // value为商品的id category_id_value为分类id
                HiosHelper.resolveAd(DemoWebviewMainActivity.this, DemoWebviewMainActivity.this, "hios://" + AppUtils.getAppPackageName() + ".hs.act.NoHiosMainActivity{act}?act={i}1&sku_id={s}2a&category_id={s}3a");
//                HiosHelper.resolveAd(DemoWebviewMainActivity.this, DemoWebviewMainActivity.this, "hios://.hs.act.NoHiosMainActivity?act={i}1&sku_id={s}2a&category_id={s}3a");
            }
        });

        findViewById(R.id.tv31).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 继承webviewactivity请求接口
                // Activity act = (Activity) container.getContext();
                // HiosHelper.resolveAd(act, mReceiver, "");
                HiosHelper.click(DemoWebviewMainActivity.this, DemoWebviewMainActivity.this, "1", "");
            }
        });

        findViewById(R.id.tv41).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 继承webviewactivity不请求接口
                // Activity act = (Activity) container.getContext();
                // HiosHelper.resolveAd(act, mReceiver, "");
                // 如果是activity中的fragment 那么 HiosHelper.resolveAd(activity, fragment, "");
//                HiosHelper.resolveAd(DemoWebviewMainActivity.this, DemoWebviewMainActivity.this, "http://liangxiao.blog.51cto.com/");
                HiosHelper.resolveAd(DemoWebviewMainActivity.this, DemoWebviewMainActivity.this, "http://www.baidu.com/?condition=login");
            }
        });

        findViewById(R.id.tv51).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 继承webviewactivity调用JS按钮
//                String aaa = "file:////android_asset/nb_mobile_new_web/index.html#/article-details?id=3492645930992144658&userId=3423267925224588188&baseUrl=http://119.188.115.241:8061/__api";
//                String aaa = "http://lzzhdj.com.cn:94/#/login";
//                try {
//                    HiosHelper.resolveAd(DemoWebviewMainActivity.this, DemoWebviewMainActivity.this, UrlEncodeUtils.encodeUrl(aaa));
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
                HiosHelper.resolveAd(DemoWebviewMainActivity.this, DemoWebviewMainActivity.this, "file:///android_asset/demo/web.html");
//                HiosHelper.resolveAd(DemoWebviewMainActivity.this, DemoWebviewMainActivity.this, "file:///android_asset/demo/test11.html");
            }
        });

        findViewById(R.id.tv61).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 嵌套webview布局
                HiosHelper.resolveAd(DemoWebviewMainActivity.this, DemoWebviewMainActivity.this, "hios://" + AppUtils.getAppPackageName() + ".ad.web.page.part{act}");
            }
        });

        //测试
//                double aa = 100.0000;
//                final BigDecimal bg = new BigDecimal(aa).setScale(2,
//                        RoundingMode.HALF_UP);
//                if (bg.doubleValue() <= 0.0) {
//                    tv3.setText("0.00");
//                } else {
//                    tv3.setText(bg + "");
//                }
    }
}
