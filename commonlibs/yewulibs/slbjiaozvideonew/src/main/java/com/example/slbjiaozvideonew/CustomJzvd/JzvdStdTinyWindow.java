package com.example.slbjiaozvideonew.CustomJzvd;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;

import cn.jzvd.JZDataSource;
import cn.jzvd.JZUtils;
import cn.jzvd.JzvdStd;

/**
 * 这个类里详细定义了进入小窗的方式，进入小窗之后小窗的操作等
 */
public class JzvdStdTinyWindow extends JzvdStd {
    public JzvdStdTinyWindow(Context context) {
        super(context);
    }

    public JzvdStdTinyWindow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setUp(JZDataSource jzDataSource, int screen, Class mediaInterface) {
        super.setUp(jzDataSource, screen, mediaInterface);
    }

    public void gotoTinyScreen() {
        Log.i(TAG, "startWindowTiny " + " [" + this.hashCode() + "] ");
        if (state == STATE_NORMAL || state == STATE_ERROR || state == STATE_AUTO_COMPLETE)
            return;
        ViewGroup vg = (ViewGroup) getParent();
        jzvdContext = vg.getContext();
        blockLayoutParams = getLayoutParams();
        blockIndex = vg.indexOfChild(this);
        blockWidth = getWidth();
        blockHeight = getHeight();

        vg.removeView(this);
        cloneAJzvd(vg);
        CONTAINER_LIST.add(vg);

        ViewGroup vgg = (ViewGroup) (JZUtils.scanForActivity(getContext())).getWindow().getDecorView();//和他也没有关系
        LayoutParams lp = new LayoutParams(400, 400);
        lp.gravity = Gravity.RIGHT | Gravity.BOTTOM;
        //添加滑动事件等
        vgg.addView(this, lp);
        setScreenTiny();
    }

}
