package com.lxj.xpopupdemo.custom;

import android.content.Context;

import androidx.annotation.NonNull;

import com.haier.cellarette.baselibrary.R;
import com.lxj.xpopup.core.PositionPopupView;

/**
 * Description: 自定义自由定位Position弹窗
 * Create by dance, at 2019/6/14
 */
public class QQMsgPopup extends PositionPopupView {
    public QQMsgPopup(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popup_qq_msg;
    }
}
