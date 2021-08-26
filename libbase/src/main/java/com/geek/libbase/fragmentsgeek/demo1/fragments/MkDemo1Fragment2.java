package com.geek.libbase.fragmentsgeek.demo1.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.geek.libbase.R;
import com.geek.libbase.base.SlbBaseLazyFragmentNew;

public class MkDemo1Fragment2 extends SlbBaseLazyFragmentNew {

    @Override
    public void call(Object value) {
        String ids = (String) value;
        ToastUtils.showLong(ids);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mk_demo1_fragment2;
    }

    @Override
    protected void setup(View rootView, @Nullable Bundle savedInstanceState) {
        super.setup(rootView, savedInstanceState);

    }
}
