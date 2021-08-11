package com.haier.cellarette.baselibrary.toasts3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haier.cellarette.baselibrary.R;
import com.haier.cellarette.baselibrary.toasts3.base.BaseDialog;
import com.haier.cellarette.baselibrary.toasts3.config.MDialogConfig;
import com.haier.cellarette.baselibrary.toasts3.utils.MSizeUtils;

/**
 * Created by maning on 2017/8/10.
 * 提示Dialog
 */
public class MStatusDialog {

    private Handler mHandler;
    private Context mContext;
    private BaseDialog mDialog;

    private MDialogConfig mDialogConfig;

    private RelativeLayout dialog_window_background;
    private RelativeLayout dialog_view_bg;
    private ImageView imageStatus;
    private TextView tvShow;

    public MStatusDialog(Context context) {
        this(context, new MDialogConfig.Builder().build());
    }

    public MStatusDialog(Context context, MDialogConfig dialogConfig) {
        mContext = context;
        mDialogConfig = dialogConfig;
        mHandler = new Handler(Looper.getMainLooper());
        //初始化
        initDialog();
    }

    private void initDialog() {
        checkDialogConfig();
        try {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View mProgressDialogView = inflater.inflate(R.layout.mn_status_dialog_layout, null);
            mDialog = new BaseDialog(mContext, R.style.MNCustomDialog);
            mDialog.setContentView(mProgressDialogView);
            mDialog.initStatusBar(mDialogConfig.windowFullscreen);
            //获取布局
            dialog_window_background = (RelativeLayout) mProgressDialogView.findViewById(R.id.dialog_window_background);
            dialog_view_bg = (RelativeLayout) mProgressDialogView.findViewById(R.id.dialog_view_bg);
            imageStatus = (ImageView) mProgressDialogView.findViewById(R.id.imageStatus);
            tvShow = (TextView) mProgressDialogView.findViewById(R.id.tvShow);

            //默认配置
            configView();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void checkDialogConfig() {
        if (mDialogConfig == null) {
            mDialogConfig = new MDialogConfig.Builder().build();
        }
    }

    private void configView() {
        //window背景
        dialog_window_background.setBackgroundColor(mDialogConfig.backgroundWindowColor);

        //文字设置
        tvShow.setTextColor(mDialogConfig.textColor);
        tvShow.setTextSize(mDialogConfig.textSize);

        //弹框背景
        GradientDrawable myGrad = new GradientDrawable();
        myGrad.setColor(mDialogConfig.backgroundViewColor);
        myGrad.setStroke(MSizeUtils.dp2px(mContext, mDialogConfig.strokeWidth), mDialogConfig.strokeColor);
        myGrad.setCornerRadius(MSizeUtils.dp2px(mContext, mDialogConfig.cornerRadius));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            dialog_view_bg.setBackground(myGrad);
        } else {
            dialog_view_bg.setBackground(myGrad);
        }
        dialog_view_bg.setPadding(
                MSizeUtils.dp2px(mContext, mDialogConfig.paddingLeft),
                MSizeUtils.dp2px(mContext, mDialogConfig.paddingTop),
                MSizeUtils.dp2px(mContext, mDialogConfig.paddingRight),
                MSizeUtils.dp2px(mContext, mDialogConfig.paddingBottom)
        );

        //设置动画
        try {
            if (mDialogConfig != null && mDialogConfig.animationID != 0 && mDialog.getWindow() != null) {
                mDialog.getWindow().setWindowAnimations(mDialogConfig.animationID);
            }
        } catch (Exception e) {

        }

        //图片宽高
        if (mDialogConfig.imgWidth > 0 && mDialogConfig.imgHeight > 0) {
            ViewGroup.LayoutParams layoutParams = imageStatus.getLayoutParams();
            layoutParams.width = MSizeUtils.dp2px(mContext, mDialogConfig.imgWidth);
            layoutParams.height = MSizeUtils.dp2px(mContext, mDialogConfig.imgHeight);
            imageStatus.setLayoutParams(layoutParams);
        }
    }

    public void show(String msg, Drawable drawable) {
        show(msg, drawable, 2000);
    }

    public void show(String msg, Drawable drawable, long delayMillis) {
        try {
            if (mDialog == null) {
                return;
            }
            if (mDialog.isShowing()) {
                mDialog.dismiss();
            }
            imageStatus.setImageDrawable(drawable);
            tvShow.setText(msg);
            mDialog.show();
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    dismiss();
                }
            }, delayMillis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismiss() {
        try {
            mContext = null;
            if (mHandler != null) {
                mHandler.removeCallbacksAndMessages(null);
                mHandler = null;
            }
            if (mDialog != null) {
                mDialog.dismiss();
                mDialog = null;
            }
            if (mDialogConfig != null && mDialogConfig.onDialogDismissListener != null) {
                mDialogConfig.onDialogDismissListener.onDismiss();
            }
        } catch (Exception e) {

        }
    }
}
