package com.example.android.touchevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.zxingtestapp.R;

public class TouchActivity extends AppCompatActivity {
    MyViewGroup viewgroup;
    MyView tv;
    MotionEvent event;
    public static final String TAG="TouchActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        initView();


    }



    private void initView() {
        viewgroup= (MyViewGroup) findViewById(R.id.viewgroup);
        tv= (MyView) findViewById(R.id.tv);
    }


    /**Activity事件*/
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG, "dispatchTouchEvent:  " +event.toString());
        return super.dispatchTouchEvent(event);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent:  "+event.toString());
        this.event=event;
        return super.onTouchEvent(event);

    }
    /**ViewGroup事件*/
    private void initViewGroupEvent(MotionEvent event) {
        viewgroup.dispatchTouchEvent(event);
        viewgroup.onTouchEvent(event);
        viewgroup.onInterceptTouchEvent(event);
    }
    /**View事件*/
    private void initViewEvent(MotionEvent event) {
        tv.dispatchTouchEvent(event);
        tv.onTouchEvent(event);
    }


}
