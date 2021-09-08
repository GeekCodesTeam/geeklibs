package xyz.doikki.dkplayer.util;

import android.text.TextUtils;

import com.blankj.utilcode.util.SPUtils;

import xyz.doikki.videoplayer.player.ProgressManager;

public class ProgressManagerImplDk2 extends ProgressManager {

    @Override
    public void saveProgress(String url, long progress) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if (progress == 0) {
            clearSavedProgressByUrl(url);
            return;
        }
        SPUtils.getInstance().put(String.valueOf(url.hashCode()), progress);
    }

    @Override
    public long getSavedProgress(String url) {
        Long pro = null;
        if (TextUtils.isEmpty(url)) {
            return 0;
        }
        pro = SPUtils.getInstance().getLong(String.valueOf(url.hashCode()),0);
//        pro = SPUtils.getInstance().getLong(url.hashCode()+"L");
        if (pro == null) {
            return 0;
        }
        return pro;
    }

    public void clearAllSavedProgress() {
        SPUtils.getInstance().clear();
    }

    public void clearSavedProgressByUrl(String url) {
        SPUtils.getInstance().put(String.valueOf(url.hashCode()), 0);
    }
}
