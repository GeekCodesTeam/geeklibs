package com.example.slbyanzheng.zhiwen2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.slbyanzheng.R;
import com.lib.lock.gesture.customview.OnPatternChangeListener;
import com.lib.lock.gesture.customview.PatternLockerView;
import com.lib.lock.gesture.utils.PatternHelper;

import java.util.List;


/**
 * 作者：xin on 2018/6/13 17:00
 * 手势密码设置
 * <p>
 * 邮箱：ittfxin@126.com
 * <P>
 * https://github.com/wzx54321/XinFrameworkLib
 */

public class GestureSettingsActivity extends AppCompatActivity {


    private TextView textMsg;
    private PatternHelper patternHelper;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, GestureSettingsActivity.class);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_settings);
        PatternLockerView patternLockerView = findViewById(R.id.pattern_lock_view);
        findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        this.textMsg = findViewById(R.id.text_msg);
        patternLockerView.setOnPatternChangedListener(new OnPatternChangeListener() {
            @Override
            public void onStart(PatternLockerView view) {
            }

            @Override
            public void onChange(PatternLockerView view, List<Integer> hitList) {
            }

            @Override
            public void onComplete(PatternLockerView view, List<Integer> hitList) {
                boolean isOk = isPatternOk(hitList);
                view.updateStatus(!isOk);
                updateMsg();
            }

            @Override
            public void onClear(PatternLockerView view) {
                finishIfNeeded();
            }
        });

        this.textMsg.setText("设置解锁图案");
        this.patternHelper = new PatternHelper();

    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    private boolean isPatternOk(List<Integer> hitList) {
        this.patternHelper.validateForSetting(hitList);
        return this.patternHelper.isOk();
    }

    private void updateMsg() {
        this.textMsg.setText(this.patternHelper.getMessage());

    }

    private void finishIfNeeded() {
        if (this.patternHelper.isFinish()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 500);

        }
    }
}
