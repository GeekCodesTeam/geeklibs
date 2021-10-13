package com.haier.cellarette.baselibrary.recycleviewcard2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.haier.cellarette.baselibrary.R;

import java.util.ArrayList;
import java.util.List;


public class StackActVertical extends AppCompatActivity {

    TextView tv1;
    RecyclerView verticalRecyclerview;
    StackLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recard2_vertical);
        tv1 = findViewById(R.id.tv1);
        verticalRecyclerview = findViewById(R.id.recyclerview_vertical);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vr();
            }
        });
        vr();
    }

    private void vr() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            datas.add(String.valueOf(i));
        }

        StackConfig config = new StackConfig();
        config.secondaryScale = 0.95f;
        config.scaleRatio = 0.4f;
        config.maxStackCount = 4;
        config.initialStackCount = 4;
        config.space = 45;
        config.parallex = 1.5f;
        config.align = StackAlign.TOP;
        layoutManager = new StackLayoutManager(config, this);
        layoutManager.stopScroll();
        layoutManager.startScroll();
        verticalRecyclerview.setLayoutManager(layoutManager);
        verticalRecyclerview.setAdapter(new StackAdapter(datas).vertical());
    }

    @Override
    protected void onResume() {
        if (layoutManager != null) {
            layoutManager.startScroll();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        if (layoutManager != null) {
            layoutManager.stopScroll();
        }
        super.onPause();
    }

}
