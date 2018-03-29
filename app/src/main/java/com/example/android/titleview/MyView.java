package com.example.android.titleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.zxingtestapp.R;

public class MyView extends LinearLayout {
    private View root = null;
    // 上面的img
    private ImageView imgView = null;
    // img下面的text
    private TextView txtView = null;
    // 上面的图像资源Id
    Drawable img;
    // 文字内容
    String text;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.myView);
        img = ta.getDrawable(R.styleable.myView_img);
        text = ta.getString(R.styleable.myView_text);
        initView(context);
        //记得此处要recycle();
        ta.recycle();
    }

    private void initView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        root = inflater.inflate(R.layout.my_view, this, true);
        imgView = (ImageView) root.findViewById(R.id.img);
        txtView = (TextView) root.findViewById(R.id.txt);
        //将自定义属性的值传递给对应View
        imgView.setBackgroundResource(R.drawable.icon_consultation);
        txtView.setText(text);
    }

}
