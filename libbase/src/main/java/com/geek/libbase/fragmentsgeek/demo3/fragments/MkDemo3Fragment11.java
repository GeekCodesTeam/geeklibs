package com.geek.libbase.fragmentsgeek.demo3.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.geek.libbase.R;
import com.geek.libbase.base.SlbBaseLazyFragmentNew;
import com.geek.libbase.fragmentsgeek.demo3.MkDemo3Activity;

/**
 * Created by shining on 2017/8/14.
 */

public class MkDemo3Fragment11 extends SlbBaseLazyFragmentNew {

    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        mContext = getActivity();
    }

    @Override
    public void call(Object value) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mk_demo3_fragment11;
    }

    @Override
    protected void setup(View rootView, @Nullable Bundle savedInstanceState) {
        super.setup(rootView, savedInstanceState);
        rootView.findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendToFragment("demo3的fragment11页面");
                ((MkDemo3Activity) mContext).changeView(1);
            }
        });
    }

    /**
     * 页面传值操作部分
     *
     * @param id1
     */
    private void SendToFragment(String id1) {
        //举例
//        IndexFoodFragmentUpdateIds iff = new IndexFoodFragmentUpdateIds();
//        iff.setFood_definition_id(id1);
//        iff.setFood_name(id2);
        if (getActivity() != null && getActivity() instanceof MkDemo3Activity) {
            ((MkDemo3Activity) getActivity()).callFragment(id1, MkDemo3Fragment20.class.getName());
        }
    }
}
