package com.example.slbjiaozvideonew;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.slbjiaozvideonew.Tab_3_List.GetGifActivity;
import com.example.slbjiaozvideonew.Tab_3_List.TinyWindow.TinyWindowActivity;
import com.example.slbjiaozvideonew.Tab_4_More.DanmuActivity;
import com.example.slbjiaozvideonew.Tab_4_More.DirectPlayActivity;
import com.example.slbjiaozvideonew.Tab_4_More.LocalVideoActivity;
import com.example.slbjiaozvideonew.Tab_4_More.SlideZoomActivity;
import com.example.slbjiaozvideonew.Tab_4_More.WebViewActivity;


/**
 * Created by pengan.li on 2020/5/8.
 */
public class Fragment_4_More extends Fragment implements View.OnClickListener {

    TextView versionTextView;
    private Button mDirectPlay, mWebView, mLocalVideo, mTinyWindow, mGetGif,mDanmu,mSlideZoom;

    public static String getAppVersionName(Context context) {
        String appVersionName = "";
        try {
            PackageInfo packageInfo = context.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            appVersionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {

        }
        return appVersionName;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
//                View.inflate(getContext(), R.layout.fragment_other, null);
        mDirectPlay = view.findViewById(R.id.direct_play);
        mWebView = view.findViewById(R.id.web_view);
        mLocalVideo = view.findViewById(R.id.local_video);
        versionTextView = view.findViewById(R.id.version);
        mTinyWindow = view.findViewById(R.id.tiny_window);
        mGetGif = view.findViewById(R.id.get_gif);
        mDanmu = view.findViewById(R.id.danmu_view);
        mSlideZoom= view.findViewById(R.id.slide_zoom);
        mSlideZoom.setOnClickListener(this);
        mDirectPlay.setOnClickListener(this);
        mWebView.setOnClickListener(this);
        mLocalVideo.setOnClickListener(this);
        mGetGif.setOnClickListener(this);
        mTinyWindow.setOnClickListener(this);
        mDanmu.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        versionTextView.setText("Version " + getAppVersionName(getContext()));

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.direct_play) {
            startActivity(new Intent(getContext(), DirectPlayActivity.class));
        } else if (id == R.id.web_view) {
            startActivity(new Intent(getContext(), WebViewActivity.class));
        } else if (id == R.id.local_video) {
            startActivity(new Intent(getContext(), LocalVideoActivity.class));
        } else if (id == R.id.tiny_window) {
            startActivity(new Intent(getContext(), TinyWindowActivity.class));
        } else if (id == R.id.get_gif) {
            startActivity(new Intent(getContext(), GetGifActivity.class));
        } else if (id == R.id.danmu_view) {
            startActivity(new Intent(getContext(), DanmuActivity.class));
        } else if (id == R.id.slide_zoom) {
            startActivity(new Intent(getContext(), SlideZoomActivity.class));
        }

    }
}
