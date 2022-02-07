package com.geek.app;

import android.content.Intent;

import com.geek.libbase.AndroidApplication;
import com.geek.libutils.app.AppUtils;
import com.geek.libutils.data.MmkvUtils;
import com.github.anrwatchdog.ANRError;
import com.github.anrwatchdog.ANRWatchDog;

public class YewuApplicationAndroid extends AndroidApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (!AppUtils.isProcessAs(getPackageName(), this)) {
            return;
        }
        //TODO commonbufen
        configBugly("BuildConfigyewu.versionNameConfig", "bcc64f431b");
        configHios();
        configmmkv();
        configShipei();
        configRetrofitNet();
        others();
        //TODO 业务bufen
        MmkvUtils.getInstance().set_xiancheng("App.isLogined", false);
        //
        new ANRWatchDog()
                .setANRListener(new ANRWatchDog.ANRListener() {
                    @Override
                    public void onAppNotResponding(ANRError error) {
                        Intent intent = getPackageManager()
                                .getLaunchIntentForPackage(getPackageName());
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                })
                .start();
    }

    @Override
    public void onHomePressed() {
        super.onHomePressed();
//        AddressSaver.addr = null;
    }
}
