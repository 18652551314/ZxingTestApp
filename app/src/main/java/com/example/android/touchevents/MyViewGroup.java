package com.example.android.touchevents;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Android on 2018/3/12.
 */

public class MyViewGroup extends RelativeLayout {
    public static final String TAG="MyViewGroup";

    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent:  " +ev.toString());
        return super.dispatchTouchEvent(ev);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent:  " +event.toString());
        return super.onTouchEvent(event);

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "onInterceptTouchEvent:  " +ev.toString());
        return super.onInterceptTouchEvent(ev);
    }
}
