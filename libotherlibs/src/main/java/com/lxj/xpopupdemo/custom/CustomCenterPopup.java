package com.lxj.xpopupdemo.custom;

import android.content.Context;

import androidx.annotation.NonNull;

import com.haier.cellarette.baselibrary.R;
import com.lxj.xpopup.core.CenterPopupView;

public class CustomCenterPopup extends CenterPopupView {
    public CustomCenterPopup(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popup_custom_center;
    }


}
