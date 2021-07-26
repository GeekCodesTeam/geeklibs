package com.example.slbappcomm.saoma.demo1;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.slbappcomm.R;
import com.king.zxing.CaptureHelper;
import com.king.zxing.OnCaptureCallback;
import com.king.zxing.ViewfinderView;

/**
 * 自定义扫码：当直接使用CaptureActivity
 * 自定义扫码，切记自定义扫码需在{@link Activity}或者{@linkFragment}相对应的生命周期里面调用{@link #mCaptureHelper}对应的生命周期
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public class CustomActivity extends AppCompatActivity implements OnCaptureCallback {

    private boolean isContinuousScan;

    private CaptureHelper mCaptureHelper;

    private SurfaceView surfaceView;

    private ViewfinderView viewfinderView;

    private View ivTorch;


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.saoma1_custom_activity);

        initUI();
    }

    private void initUI(){

        Toolbar toolbar = findViewById(R.id.toolbar);
        SaomaStatusBarUtils.immersiveStatusBar(this,toolbar,0.2f);
        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText(getIntent().getStringExtra(SaomaAct.KEY_TITLE));


        surfaceView = findViewById(R.id.surfaceView);
        viewfinderView = findViewById(R.id.viewfinderView);
        ivTorch = findViewById(R.id.ivFlash);
        ivTorch.setVisibility(View.INVISIBLE);

        isContinuousScan = getIntent().getBooleanExtra(SaomaAct.KEY_IS_CONTINUOUS,false);

        mCaptureHelper = new CaptureHelper(this,surfaceView,viewfinderView,ivTorch);
        mCaptureHelper.setOnCaptureCallback(this);
        mCaptureHelper.onCreate();
        mCaptureHelper.vibrate(true)
                .fullScreenScan(true)//全屏扫码
                .supportVerticalCode(true)//支持扫垂直条码，建议有此需求时才使用。
                .supportLuminanceInvert(true)//是否支持识别反色码（黑白反色的码），增加识别率
                .continuousScan(isContinuousScan);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mCaptureHelper.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCaptureHelper.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCaptureHelper.onDestroy();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mCaptureHelper.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


    /**
     * 扫码结果回调
     * @param result 扫码结果
     * @return
     */
    @Override
    public boolean onResultCallback(String result) {
        if(isContinuousScan){
            Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
        }
        return false;
    }



    public void onClick(View v){
        if (v.getId() == R.id.ivLeft) {
            onBackPressed();
        }
    }
}