package com.example.android.glide;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.ViewTarget;
import com.example.android.zxingtestapp.R;

public class GlideActivity extends AppCompatActivity {
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        String url = "http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436.jpg";
        mImageView = (ImageView) findViewById(R.id.imageView);
        int width = 300, height = 300;


//        SimpleTarget<Bitmap> mSimpleTarget = new SimpleTarget<Bitmap>(500, 500) {
//            @Override
//            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> animation) {
//                mImageView.setImageBitmap(resource);
//            }
//        };

        //自定义控件加载
        CustomView mCustomView = (CustomView) findViewById(R.id.custom_view);
        ViewTarget viewTarget = new ViewTarget<CustomView, GlideDrawable>(mCustomView) {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                this.view.setImage(resource);
            }
        };
        Glide.with(this).load(url).into(viewTarget);
        //自定义view加载动画animator
//        ViewPropertyAnimation.Animator animator = new ViewPropertyAnimation.Animator() {
//            @Override
//            public void animate(View view) {
//                view.setAlpha(0f);
//                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
//                fadeAnim.setDuration(2500);
//                fadeAnim.start();
//            }
//        };


        Glide.with(this)
                .load(url)
//                .crossFade()//或者使用 dontAnimate() 关闭动画
                .placeholder(R.drawable.scene1)//图片加载出来前，显示的图片
                .error(R.drawable.scene2)//图片加载失败后，显示的图片
                .override(width, height)//图片大小与裁剪,这里的单位是px
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//只缓存全尺寸图
                .priority(Priority.HIGH)//图片请求的优先级
//                .asGif()//显示 Gif 和 Video
//                .asBitmap()//显示 Gif 但只是向显示 静态的图片你就可以这么做,仅仅是显示 Gif 的第一帧图像
                .transform(new RoundTransformation(this, 20))//圆角
//                .animate( R.anim.zoom_in )//插入动画//自定义 .animate( animator )

                .into(mImageView);//into(mSimpleTarget)//viewTarget

    }


}
