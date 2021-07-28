package com.example.slbappcomm.saoma.demo2;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.slbappcomm.R;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;


/**
 * @author : yzq
 * @description: 扫码Fragemnt
 * @date : 2019/3/25
 * @time : 17:12
 */

public class SaomaAct2Fragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button scanButton;
    private TextView resultTv;

    public SaomaAct2Fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_saoma2_scan, container, false);


        initView();

        return view;
    }

    private void initView() {
        scanButton = view.findViewById(R.id.scanBtn);
        resultTv = view.findViewById(R.id.resultTv);
        scanButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getActivity(), CaptureActivity.class);
        getActivity().startActivityForResult(intent, 1111);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1111) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);

                resultTv.setText("扫描结果为：" + content);
            }
        }


    }
}
