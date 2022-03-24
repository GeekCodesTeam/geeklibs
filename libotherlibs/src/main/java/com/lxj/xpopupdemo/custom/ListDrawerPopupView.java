package com.lxj.xpopupdemo.custom;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.haier.cellarette.baselibrary.R;
import com.lxj.easyadapter.EasyAdapter;
import com.lxj.easyadapter.ViewHolder;
import com.lxj.xpopup.core.DrawerPopupView;

import java.util.ArrayList;

/**
 * Description: 自定义带列表的Drawer弹窗
 * Create by dance, at 2019/1/9
 */
public class ListDrawerPopupView extends DrawerPopupView {
    RecyclerView recyclerView;

    public ListDrawerPopupView(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.custom_list_drawer;
    }

    final ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        for (int i = 0; i < 50; i++) {
            data.add("" + i);
        }

        final EasyAdapter<String> commonAdapter = new EasyAdapter<String>(data, android.R.layout.simple_list_item_1) {
            @Override
            protected void bind(@NonNull ViewHolder holder, @NonNull String s, int position) {
                holder.setText(android.R.id.text1, s);
            }
        };

        recyclerView.setAdapter(commonAdapter);
        findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(data.size()==0)return;
//                data.remove(0);
//                commonAdapter.notifyDataSetChanged();
                dismiss();
            }
        });

    }
}
