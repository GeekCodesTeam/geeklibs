package com.lib.lock.gesture.customview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lib.lock.gesture.bean.CellBean;
import com.lib.lock.gesture.config.Config;

import java.util.List;

/**
 */

public class DefaultLockerLinkedLineView implements ILockerLinkedLineView {
    private static final String TAG = "LockerLinkedLineView";

    private @ColorInt
    int normalColor;
    private @ColorInt
    int errorColor;
    private @ColorInt
    int hitColor;

    private float lineWidth;


    private Paint paint;


    public DefaultLockerLinkedLineView() {
        this.paint = Config.createPaint();
        this.paint.setStyle(Paint.Style.STROKE);
    }

    public int getNormalColor() {
        return normalColor;
    }

    public DefaultLockerLinkedLineView setNormalColor(int normalColor) {
        this.normalColor = normalColor;
        return this;
    }

    public int getErrorColor() {
        return errorColor;
    }

    public ILockerLinkedLineView setHitColor(int hitColor) {
        this.hitColor = hitColor;
        return this;
    }


    public int getHitColor() {
        return hitColor;
    }

    public DefaultLockerLinkedLineView setErrorColor(int errorColor) {
        this.errorColor = errorColor;
        return this;
    }

    public float getLineWidth() {
        return lineWidth;
    }

    public DefaultLockerLinkedLineView setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    @Override
    public void draw(@NonNull Canvas canvas, @Nullable List<Integer> hitList, @NonNull List<CellBean> cellBeanList,
                     float endX, float endY, boolean isError) {
        if (hitList == null || hitList.isEmpty() || cellBeanList.isEmpty()) {
            return;
        }

        final int saveCount = canvas.save();

        final Path path = new Path();

        CellBean first = cellBeanList.get(hitList.get(0));
        path.moveTo(first.x, first.y);
        for (int i = 1; i < hitList.size(); i++) {
            CellBean c = cellBeanList.get(hitList.get(i));
            path.lineTo(c.x, c.y);
        }

        if (((endX != 0) || (endY != 0)) && (hitList.size() < 9)) {
            path.lineTo(endX, endY);
        }

        this.paint.setColor(this.getColor(isError));
        this.paint.setStrokeWidth(this.getLineWidth());
        canvas.drawPath(path, this.paint);

        canvas.restoreToCount(saveCount);
    }

    private @ColorInt
    int getColor(boolean isError) {
        return isError ? this.getErrorColor() : this.getHitColor();
    }


}
