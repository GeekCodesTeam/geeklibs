package com.lib.lock.gesture.customview;

import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import com.lib.lock.gesture.bean.CellBean;
import com.lib.lock.gesture.config.Config;

/**
 */

public class DefaultIndicatorHitCellView implements  IHitCellView {

    private @ColorInt
    int normalColor;
    private @ColorInt
    int errorColor;

    private Paint paint;

    public DefaultIndicatorHitCellView() {
        this.paint = Config.createPaint();
        this.paint.setStyle(Paint.Style.FILL);
    }

    public int getNormalColor() {
        return normalColor;
    }

    public DefaultIndicatorHitCellView setNormalColor(int normalColor) {
        this.normalColor = normalColor;
        return this;
    }

    public int getErrorColor() {
        return errorColor;
    }

    public DefaultIndicatorHitCellView setErrorColor(int errorColor) {
        this.errorColor = errorColor;
        return this;
    }

    @Override
    public void draw(@NonNull Canvas canvas, @NonNull CellBean cellBean, boolean isError) {
        int saveCount = canvas.save();

        this.paint.setColor(this.getColor(isError));
        canvas.drawCircle(cellBean.x, cellBean.y, cellBean.radius, this.paint);

        canvas.restoreToCount(saveCount);
    }

    private int getColor(boolean isError) {
        return isError ? this.getErrorColor() : this.getNormalColor();
    }
}