package com.example.slbappcomm.uploadimg2;

import android.app.Activity;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.slbappcomm.R;
import com.geek.libutils.app.BaseApp;
import com.lzy.imagepicker.loader.ImageLoader;

import java.io.File;

/**
 * Created by shining on 2017/11/8.
 */

public class GlideImageLoader2 implements ImageLoader {
    @Override
    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
        //glide3.7.0
//        Glide.with(activity)                             //配置上下文
//                .load(Uri.fromFile(new File(path)))      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
//                .placeholder(R.drawable.ic_default_image)     //设置占位图片
//                .error(R.drawable.ic_default_image)           //设置错误图片
//                .diskCacheStrategy(DiskCacheStrategy.RESULT)//缓存全尺寸
//                .into(imageView);
        //glide4.1.1
        final RequestOptions options = new RequestOptions()
//                .override(Target.SIZE_ORIGINAL)
//                .transform(new RoundedCorners(50))
                .centerCrop()
                .placeholder(R.drawable.ic_def_loading)
                .error(R.drawable.ic_def_loading)
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//                .priority(Priority.NORMAL)
                /*.transform(new RoundedCornersTransformation(imageView.getContext(), 0, 0))*/;
        Glide.with(activity)
                .load(Uri.fromFile(new File(path)))
                .apply(options)
                .into(imageView);
    }

    @Override
    public void displayImagePreview(Activity activity, String path, ImageView imageView, int width, int height) {
        //glide3.7.0
//        Glide.with(activity)                             //配置上下文
//                .load(Uri.fromFile(new File(path)))      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
//                .diskCacheStrategy(DiskCacheStrategy.RESULT)//缓存全尺寸
//                .into(imageView);
        //glide4.1.1
        final RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_def_loading)
                .error(R.drawable.ic_def_loading)
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                /*.transform(new RoundedCornersTransformation(imageView.getContext(), 0, 0))*/;
        Glide.with(activity)
                .load(Uri.fromFile(new File(path)))
                .apply(options)
                .into(imageView);
    }

    @Override
    public void clearMemoryCache() {
        Glide.get(BaseApp.get()).clearMemory();
    }
}
