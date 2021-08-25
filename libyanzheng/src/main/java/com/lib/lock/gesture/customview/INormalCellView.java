package com.lib.lock.gesture.customview;

import android.graphics.Canvas;

import androidx.annotation.NonNull;

import com.lib.lock.gesture.bean.CellBean;

/**
 */

public interface INormalCellView {
    /**
     * 绘制正常情况下（即未设置的）每个图案的样式
     *
     * @param canvas
     * @param cellBean the target cell view
     */
    void draw(@NonNull Canvas canvas, @NonNull CellBean cellBean);
}