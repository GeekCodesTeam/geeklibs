package com.haier.cellarette.baselibrary.recycleviewcard2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.haier.cellarette.baselibrary.R;

import java.util.ArrayList;
import java.util.List;

public class StackAct extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    RecyclerView recyclerview;
    RecyclerView hrRecyclerView;
    Button button;
    Button button1;
    Button button2;
    Button scroll_to_specific_item;
    private StackLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recard2);
        recyclerview = findViewById(R.id.recyclerview);
        hrRecyclerView = findViewById(R.id.recyclerview1);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        scroll_to_specific_item = findViewById(R.id.scroll_to_specific_item);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetDefault();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetRight();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewVertical();
            }
        });
        scroll_to_specific_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onScrollToItem();
            }
        });
        resetDefault();
        resetRight();
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

    public void resetDefault() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            datas.add(String.valueOf(i));
        }

        StackConfig config = new StackConfig();
        config.secondaryScale = 0.8f;
        config.scaleRatio = 0.4f;
        config.maxStackCount = 4;
        config.initialStackCount = 2;
        config.mScrollTime = 2000;
        config.space = 15;
        config.align = StackAlign.LEFT;
        layoutManager = new StackLayoutManager(config, this);
        layoutManager.stopScroll();
        layoutManager.startScroll();
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(new StackAdapter(datas));

    }

    public void resetRight() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            datas.add(String.valueOf(i));
        }

        StackConfig config = new StackConfig();
        config.secondaryScale = 0.8f;
        config.scaleRatio = 0.4f;
        config.maxStackCount = 4;
        config.initialStackCount = 2;
        config.space = getResources().getDimensionPixelOffset(R.dimen.item_space);
        config.align = StackAlign.RIGHT;
        layoutManager = new StackLayoutManager(config, this);
        layoutManager.stopScroll();
        layoutManager.startScroll();
        hrRecyclerView.setLayoutManager(layoutManager);
        hrRecyclerView.setAdapter(new StackAdapter(datas));
    }

    public void viewVertical() {
        startActivity(new Intent(this, StackActVertical.class));
    }

    public void onScrollToItem() {
        layoutManager.scrollToPosition(10);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
