package xyz.doikki.dkplayer.widget.controller;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import xyz.doikki.dkplayer.widget.component.DebugInfoViewDk;
import xyz.doikki.videoplayer.controller.BaseVideoController;

/**
 * 抖音
 * Created by Doikki on 2018/1/6.
 */

public class TikTokControllerDk extends BaseVideoController {

    public TikTokControllerDk(@NonNull Context context) {
        super(context);
    }

    public TikTokControllerDk(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TikTokControllerDk(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        //显示调试信息
        addControlComponent(new DebugInfoViewDk(getContext()));
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public boolean showNetWarning() {
        //不显示移动网络播放警告
        return false;
    }
}
