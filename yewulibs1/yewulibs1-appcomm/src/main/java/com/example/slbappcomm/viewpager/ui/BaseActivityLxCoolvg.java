package com.example.slbappcomm.viewpager.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.slbappcomm.viewpager.LxCoolViewPager;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/6/1 16:15
 */
public class BaseActivityLxCoolvg extends AppCompatActivity {
    public void jump(Class clazz) {
        startActivity(new Intent(BaseActivityLxCoolvg.this, clazz));
    }

    private Map<String, Bitmap> imgs = new HashMap<String, Bitmap>();

    public View createImageView(int imgResId) {
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LxCoolViewPager.LayoutParams());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (imgs.get("" + imgResId) != null) {
            imageView.setImageBitmap(imgs.get("" + imgResId));
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgResId, options);
            imgs.put("" + imgResId, bitmap);
            imageView.setImageBitmap(bitmap);
        }
        return imageView;
    }
}