package com.geek.libutils.shortcut;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.AppUtils;
import com.geek.libutils.data.MmkvUtils;

import java.util.List;

/**
 * Created by ZP on 2019-07-12.
 */
public class TransparentActivity extends Activity {
    private static final String TAG = "TransparentActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null) {
            boolean isShortcut = intent.getBooleanExtra("isShortcut", false);
            String name = intent.getStringExtra("name");
            String uid = intent.getStringExtra("id");
            Log.d(TAG, "onCreate: isShortcut = " + isShortcut + "，name = " + name + "，uid = " + uid);
            if (!isMainTaskEmpty() || isLogined()) {
                Intent welcomeIntent = new Intent(AppUtils.getAppPackageName() + ".hs.act.slbapp.ShouyeActivity");
                startActivity(welcomeIntent);
            } else {
                Intent welcomeIntent = new Intent(Intent.ACTION_MAIN);
                welcomeIntent.setClassName(AppUtils.getAppPackageName(), name);
                startActivity(welcomeIntent);
            }
        }
    }

    private boolean isLogined() {
        return MmkvUtils.getInstance().get_xiancheng_bool("App.isLogined");
    }


    private boolean isMainTaskEmpty() {
        boolean empty = true;
        this.finish();
        ActivityManager am = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(100);
        if (tasks != null && !tasks.isEmpty()) {
            for (ActivityManager.RunningTaskInfo rti : tasks) {
                //找到当前应用的task，并启动task的栈顶activity，达到程序切换到前台
                if (rti.topActivity.getPackageName().equals(getPackageName())) {
                    if (!rti.topActivity.equals(getComponentName())) {
                        empty = false;
                        break;
                    }
                }
            }
        }
        return empty;
    }
}
