package com.haier.cellarette.baselibrary.toasts3.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.haier.cellarette.baselibrary.R;

/**
 * Created by Mikhael LOPEZ on 16/10/2015.
 * 引用：https://github.com/lopspower/CircularProgressBar
 */
public class MNHudCircularProgressBar extends View {

    // Properties
    private float progress = 0;
    private float lastProgress = 0;
    private float strokeWidth = 10;
    private float backgroundStrokeWidth = 10;
    private int color = Color.BLACK;
    private int backgroundColor = Color.GRAY;
    //动画时长
    private long mDuration = 300;

    // Object used to draw
    private int startAngle = -90;
    private RectF rectF;
    private Paint backgroundPaint;
    private Paint foregroundPaint;

    //region Constructor & Init Method
    public MNHudCircularProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        rectF = new RectF();
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MNHudCircularProgressBar, 0, 0);
        //Reading values from the XML layout
        try {
            // Value
            progress = typedArray.getFloat(R.styleable.MNHudCircularProgressBar_mn_progress, progress);
            // StrokeWidth
            strokeWidth = typedArray.getDimension(R.styleable.MNHudCircularProgressBar_mn_progressbar_width, strokeWidth);
            backgroundStrokeWidth = typedArray.getDimension(R.styleable.MNHudCircularProgressBar_mn_background_progressbar_width, backgroundStrokeWidth);
            // Color
            color = typedArray.getInt(R.styleable.MNHudCircularProgressBar_mn_progressbar_color, color);
            backgroundColor = typedArray.getInt(R.styleable.MNHudCircularProgressBar_mn_background_progressbar_color, backgroundColor);
        } finally {
            typedArray.recycle();
        }

        // Init Background
        backgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        backgroundPaint.setColor(backgroundColor);
        backgroundPaint.setStyle(Paint.Style.STROKE);
        backgroundPaint.setStrokeWidth(backgroundStrokeWidth);

        // Init Foreground
        foregroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        foregroundPaint.setColor(color);
        foregroundPaint.setStyle(Paint.Style.STROKE);
        foregroundPaint.setStrokeWidth(strokeWidth);
    }
    //endregion

    //region Draw Method
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(rectF, backgroundPaint);
        float angle = 360 * progress / 100;
        Log.e("MProgressBarDialog4",progress+"");
        Log.e("MProgressBarDialog5",angle+"");
        canvas.drawArc(rectF, startAngle, angle, false, foregroundPaint);
    }
    //endregion

    //region Mesure Method
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        final int width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        final int min = Math.min(width, height);
        setMeasuredDimension(min, min);
        float highStroke = (strokeWidth > backgroundStrokeWidth) ? strokeWidth : backgroundStrokeWidth;
        rectF.set(0 + highStroke / 2, 0 + highStroke / 2, min - highStroke / 2, min - highStroke / 2);
    }
    //endregion

    //region Method Get/Set
    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        setProgress(progress, true);
    }

    public void setProgress(float progress, boolean animal) {
        this.progress = (progress <= 100) ? progress : 100;
        if (animal) {
            //开启动画
            startAnim();
            this.lastProgress = progress;
            Log.e("MProgressBarDialog3",lastProgress+"");
        } else {
            invalidate();
        }

    }

    //动画
    public void startAnim() {
        Log.e("MProgressBarDialog1",lastProgress+"");
        Log.e("MProgressBarDialog2",progress+"");
        ValueAnimator mAngleAnim = ValueAnimator.ofFloat(lastProgress+1, progress+1);
        mAngleAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        mAngleAnim.setDuration(mDuration);
        mAngleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                progress = (float) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        mAngleAnim.start();
    }

    public float getProgressBarWidth() {
        return strokeWidth;
    }

    public void setProgressBarWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
        foregroundPaint.setStrokeWidth(strokeWidth);
        requestLayout();//Because it should recalculate its bounds
        invalidate();
    }

    public float getBackgroundProgressBarWidth() {
        return backgroundStrokeWidth;
    }

    public void setBackgroundProgressBarWidth(float backgroundStrokeWidth) {
        this.backgroundStrokeWidth = backgroundStrokeWidth;
        backgroundPaint.setStrokeWidth(backgroundStrokeWidth);
        requestLayout();//Because it should recalculate its bounds
        invalidate();
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        foregroundPaint.setColor(color);
        invalidate();
        requestLayout();
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        backgroundPaint.setColor(backgroundColor);
        invalidate();
        requestLayout();
    }
    //endregion

    //region Other Method

    /**
     * Set the progress with an animation.
     *
     * @param progress The progress it should animate to it.
     */
    public void setProgressWithAnimation(float progress) {
        setProgressWithAnimation(progress, 1500);
    }

    /**
     * Set the progress with an animation.
     *
     * @param progress The progress it should animate to it.
     * @param duration The length of the animation, in milliseconds.
     */
    public void setProgressWithAnimation(float progress, int duration) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "progress", progress);
        objectAnimator.setDuration(duration);
        objectAnimator.setInterpolator(new DecelerateInterpolator());
        objectAnimator.start();
    }
    //endregion
}
