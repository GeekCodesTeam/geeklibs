package com.haier.cellarette.baselibrary.toasts3.demo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.haier.cellarette.baselibrary.R;
import com.haier.cellarette.baselibrary.toasts3.MProgressBarDialog;
import com.haier.cellarette.baselibrary.toasts3.MProgressDialog;
import com.haier.cellarette.baselibrary.toasts3.MStatusDialog;
import com.haier.cellarette.baselibrary.toasts3.MToast;
import com.haier.cellarette.baselibrary.toasts3.config.MDialogConfig;
import com.haier.cellarette.baselibrary.toasts3.config.MToastConfig;
import com.haier.cellarette.baselibrary.toasts3.listeners.OnDialogDismissListener;


public class MnMainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String text01 = "从前有坐山,山上有坐庙,庙里有个老和尚在讲故事,讲的什么啊,从前有座山,山里有座庙,庙里有个盆,盆里有个锅,锅里有个碗,碗里有个匙,匙里有个花生仁,我吃了,你谗了,我的故事讲完了.";
    private Context mContext;
    private Handler mHandler = new Handler();


    private MProgressBarDialog mProgressBarDialog;

    private Button btn01;
    private Button btn02;
    private Button btn03;
    private Button btn04;
    private Button btn06;
    private Button btn07;
    private Button btn10;
    private Button btn11;
    private Button btn12;
    private Button btn13;
    private Button btn14;
    private Button btn15;
    private Button btn16;
    private Button btn17;
    private Button btn18;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(
//                WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mn);
        mContext = this;

        initViews();
    }


    private void initViews() {
        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);
        btn03 = findViewById(R.id.btn03);
        btn04 = findViewById(R.id.btn04);
        btn06 = findViewById(R.id.btn06);
        btn07 = findViewById(R.id.btn07);
        btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        btn13 = findViewById(R.id.btn13);
        btn14 = findViewById(R.id.btn14);
        btn15 = findViewById(R.id.btn15);
        btn16 = findViewById(R.id.btn16);
        btn17 = findViewById(R.id.btn17);
        btn18 = findViewById(R.id.btn18);

        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
        btn04.setOnClickListener(this);
        btn06.setOnClickListener(this);
        btn07.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);
        btn17.setOnClickListener(this);
        btn18.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn01) {
            MProgressDialog.showProgress(this);
            //延时关闭
            delayDismissProgressDialog();
        } else if (id == R.id.btn02) {
            MProgressDialog.showProgress(this, text01);
            //延时关闭
            delayDismissProgressDialog();
        } else if (id == R.id.btn03) {
            MProgressDialog.showProgress(this, "加载中...");
            //延时关闭
            delayDismissProgressDialog();
        } else if (id == R.id.btn04) {
            MDialogConfig mDialogConfig = new MDialogConfig.Builder()
                    //全屏模式
                    .isWindowFullscreen(true)
                    //Progress大小（宽高）
                    .setProgressSize(60)
                    //点击外部是否可以取消
                    .isCanceledOnTouchOutside(true)
                    //物理返回键可以取消
                    .isCancelable(true)
                    //全屏背景窗体的颜色
                    .setBackgroundWindowColor(getMyColor(R.color.colorDialogWindowBg))
                    //View背景的颜色
                    .setBackgroundViewColor(getMyColor(R.color.colorDialogViewBg))
                    //View背景的圆角
                    .setCornerRadius(20)
                    //View 边框的颜色
                    .setStrokeColor(getMyColor(R.color.colorotherlibs))
                    //View 边框的宽度
                    .setStrokeWidth(2)
                    //Progress 颜色
                    .setProgressColor(getMyColor(R.color.colorDialogProgressBarColor))
                    //Progress 宽度
                    .setProgressWidth(3)
                    //Progress 内圈颜色
                    .setProgressRimColor(Color.YELLOW)
                    //Progress 内圈宽度
                    .setProgressRimWidth(4)
                    //文字的颜色
                    .setTextColor(getMyColor(R.color.colorDialogTextColor))
                    //文字的大小
                    .setTextSize(15)
                    //ProgressBar 颜色
                    .setProgressColor(Color.GREEN)
                    //dialog动画
                    .setAnimationID(R.style.mn_animate_dialog_custom)
                    //padding
                    .setPadding(40, 10, 40, 10)
                    //关闭的监听
                    .setOnDialogDismissListener(new OnDialogDismissListener() {
                        @Override
                        public void onDismiss() {
                            MToast.makeTextShort(mContext, "监听到了ProgressDialog关闭了");
                        }
                    })
                    .build();
            MProgressDialog.showProgress(this, "数据上传中...", mDialogConfig);
        } else if (id == R.id.btn06) {
            showStatusDialog01();
        } else if (id == R.id.btn07) {
            showStatusDialog02();
        } else if (id == R.id.btn10) {
            showToast();
        } else if (id == R.id.btn11) {
            showToastCustom();
        } else if (id == R.id.btn12) {
            showToastCustom2();
        } else if (id == R.id.btn13) {
            showToastCustom3();
        } else if (id == R.id.btn14) {
            configProgressbarHorizontalDialog();
            startProgress(true);
        } else if (id == R.id.btn15) {
            configProgressbarHorizontalDialog2();
            startProgress(false);
        } else if (id == R.id.btn16) {
            configProgressbarCircleDialog();
            startProgress(true);
        } else if (id == R.id.btn17) {
            configProgressbarCircleDialog2();
            startProgress(false);
        } else if (id == R.id.btn18) {
            showFragmentDialog();
        }
    }

    private void showFragmentDialog() {
        MnTestFragmentDialog testFragmentDialog = new MnTestFragmentDialog();
        testFragmentDialog.showDialog(MnMainActivity.this);
    }


    /**
     * --------------------MProgressDialog start -------------------
     */

    private int getMyColor(int colorID) {
        return mContext.getResources().getColor(colorID);
    }


    private void delayDismissProgressDialog() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                MProgressDialog.dismissProgress();
            }
        }, 3000);
    }


    /** --------------------MProgressDialog end ------------------- */


    /**
     * --------------------MToast start -------------------
     */

    private void showToastCustom3() {
        MToastConfig config = new MToastConfig.Builder()
                .setBackgroundStrokeColor(Color.YELLOW)
                .setBackgroundStrokeWidth(1)
                .setBackgroundCornerRadius(20)
                .build();
        MToast.makeTextShort(mContext, text01, config);
    }

    private void showToastCustom2() {
        MToastConfig config = new MToastConfig.Builder()
                .setGravity(MToastConfig.MToastGravity.CENTRE)
                .setTextColor(Color.MAGENTA)
                .setBackgroundColor(getMyColor(R.color.colorDialogTest))
                .setToastIcon(mContext.getResources().getDrawable(R.drawable.mn_icon_dialog_ok))
                .setBackgroundCornerRadius(10)
                .setTextSize(13)
                .setImgWidthAndHeight(40, 40)
                .setPadding(20, 20, 20, 20)
                .build();
        MToast.makeTextShort(mContext, text01, config);
    }

    private void showToastCustom() {
        MToastConfig config = new MToastConfig.Builder()
                .setTextColor(getMyColor(R.color.white))
                .setBackgroundColor(getMyColor(R.color.colorDialogTest))
                .setToastIcon(mContext.getResources().getDrawable(R.drawable.mn_icon_dialog_ok))
                .setTextSize(18)
                .build();
        MToast.makeTextShort(mContext, "欢迎使用自定义Toast", config);

    }

    private void showToast() {
        MToast.makeTextShort(mContext, "我是默认Toast");
    }


    /** --------------------MToast start ------------------- */


    /**
     * --------------------MStatusDialog start -------------------
     */

    private MStatusDialog mStatusDialog;

    private void showStatusDialog01() {
        mStatusDialog = new MStatusDialog(this);
        mStatusDialog.show("正在保存,请稍等..", mContext.getResources().getDrawable(R.drawable.mn_icon_dialog_ok), 5000);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //关闭
                mStatusDialog.dismiss();
                new MStatusDialog(mContext).show("保存成功", mContext.getResources().getDrawable(R.drawable.mn_icon_dialog_ok));
            }
        }, 1000);
    }

    private void showStatusDialog02() {
        MDialogConfig mDialogConfig = new MDialogConfig.Builder()
                //全屏模式
                .isWindowFullscreen(true)
                //全屏背景窗体的颜色
                .setBackgroundWindowColor(getMyColor(R.color.colorDialogWindowBg))
                //View背景的颜色
                .setBackgroundViewColor(getMyColor(R.color.colorDialogViewBg2))
                //字体的颜色
                .setTextColor(getMyColor(R.color.colorotherlibs))
                //文字大小
                .setTextSize(13)
                //View边框的颜色
                .setStrokeColor(getMyColor(R.color.white))
                //View边框的宽度
                .setStrokeWidth(2)
                //View圆角大小
                .setCornerRadius(10)
                //动画
                .setAnimationID(R.style.mn_animate_dialog_custom)
                //图片的宽高dp
                .setImgWidthAndHeight(60, 60)
                //padding
                .setPadding(40, 10, 40, 10)
                //关闭的监听
                .setOnDialogDismissListener(new OnDialogDismissListener() {
                    @Override
                    public void onDismiss() {
                        MToast.makeTextShort(mContext, "监听到了MStatusDialog关闭了");
                    }
                })
                .build();
        new MStatusDialog(mContext, mDialogConfig)
                .show("恭喜你，签到成功\n积分+10",
                        mContext.getResources().getDrawable(R.drawable.mn_icon_staues_test),
                        1500);
    }

    /** --------------------MStatusDialog end ------------------- */


    /**
     * --------------------MProgressBarDialog start -------------------
     */
    private void configProgressbarCircleDialog() {
        //新建一个Dialog
        mProgressBarDialog = new MProgressBarDialog.Builder(mContext)
                .setStyle(MProgressBarDialog.MProgressBarDialogStyle_Circle)
                .build();
    }

    private void configProgressbarCircleDialog2() {
        //新建一个Dialog
        mProgressBarDialog = new MProgressBarDialog.Builder(mContext)
                //全屏模式
                .isWindowFullscreen(true)
                //样式
                .setStyle(MProgressBarDialog.MProgressBarDialogStyle_Circle)
                //全屏背景窗体的颜色
                .setBackgroundWindowColor(getMyColor(R.color.colorDialogWindowBg))
                //View背景的颜色
                .setBackgroundViewColor(getMyColor(R.color.colorDialogViewBg2))
                //字体的颜色
                .setTextColor(getMyColor(R.color.colorotherlibs))
                //View边框的颜色
                .setStrokeColor(getMyColor(R.color.white))
                //View边框的宽度
                .setStrokeWidth(2)
                //View圆角大小
                .setCornerRadius(10)
                //ProgressBar背景色
                .setProgressbarBackgroundColor(Color.BLUE)
                //ProgressBar 颜色
                .setProgressColor(Color.GREEN)
                //圆形内圈的宽度
                .setCircleProgressBarWidth(4)
                //圆形外圈的宽度
                .setCircleProgressBarBackgroundWidth(4)
                //dialog动画
                .setAnimationID(R.style.mn_animate_dialog_custom)
                .build();
    }

    private void configProgressbarHorizontalDialog() {
        //新建一个Dialog
        mProgressBarDialog = new MProgressBarDialog.Builder(mContext)
                .setStyle(MProgressBarDialog.MProgressBarDialogStyle_Horizontal)
                .build();
    }

    private void configProgressbarHorizontalDialog2() {
        //新建一个Dialog
        mProgressBarDialog = new MProgressBarDialog.Builder(mContext)
                .setStyle(MProgressBarDialog.MProgressBarDialogStyle_Horizontal)
                //全屏背景窗体的颜色
                .setBackgroundWindowColor(getMyColor(R.color.colorDialogWindowBg))
                //View背景的颜色
                .setBackgroundViewColor(getMyColor(R.color.colorDialogViewBg2))
                //字体的颜色
                .setTextColor(getMyColor(R.color.colorotherlibs))
                //View边框的颜色
                .setStrokeColor(getMyColor(R.color.white))
                //View边框的宽度
                .setStrokeWidth(2)
                //View圆角大小
                .setCornerRadius(10)
                //ProgressBar背景色
                .setProgressbarBackgroundColor(Color.BLUE)
                //ProgressBar 颜色
                .setProgressColor(Color.GREEN)
                //水平进度条Progress圆角
                .setProgressCornerRadius(0)
                //水平进度条的高度
                .setHorizontalProgressBarHeight(10)
                //dialog动画
                .setAnimationID(R.style.mn_animate_dialog_custom)
                .build();
    }

    //当前进度
    private int currentProgress;
    //是否开启动画：平滑过度，默认开启
    private boolean animal = true;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (currentProgress < 100) {
                mProgressBarDialog.showProgress(currentProgress, "当前进度为：" + currentProgress + "%", animal);
                currentProgress += 5;
                mHandler.postDelayed(runnable, 200);
            } else {
                mHandler.removeCallbacks(runnable);
                currentProgress = 0;
                mProgressBarDialog.showProgress(100, "完成", animal);
                //关闭
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mProgressBarDialog.dismiss();
                    }
                }, 1000);
            }
        }
    };

    private void startProgress(boolean animal) {
        this.animal = animal;
        mHandler.post(runnable);
    }

    /**
     * --------------------MProgressBarDialog end -------------------
     */
}
