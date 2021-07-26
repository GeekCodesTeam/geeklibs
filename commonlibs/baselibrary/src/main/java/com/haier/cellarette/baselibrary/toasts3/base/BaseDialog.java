package com.haier.cellarette.baselibrary.toasts3.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.haier.cellarette.baselibrary.toasts3.utils.MSizeUtils;

/**
 * @author : maning
 * @desc :
 */
public class BaseDialog extends Dialog {

    public BaseDialog(Context context) {
        this(context,0);
    }

    public BaseDialog(Context context, int themeResId) {
        super(context, themeResId);
        init();
    }


    private void init() {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setDialogWidthHeight();
    }

    public void setDialogWidthHeight() {
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.width = MSizeUtils.getScreenWidth(getContext());
        layoutParams.height = MSizeUtils.getScreenHeight(getContext());
        layoutParams.gravity = Gravity.CENTER;
        getWindow().setAttributes(layoutParams);
    }

    public void initStatusBar(boolean windowFullscreen) {
        //全屏模式
        if (windowFullscreen) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                getWindow().setFlags(
                        WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
            } else {
                int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN;
                getWindow().getDecorView().setSystemUiVisibility(uiOptions);
            }
        }
    }

    @Override
    public void show() {
        super.show();
    }

}
