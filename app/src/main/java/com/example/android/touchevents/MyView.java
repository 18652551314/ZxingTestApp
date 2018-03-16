package com.example.android.touchevents;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;


/**
 * Created by Android on 2018/3/12.
 */

public class MyView extends Button {
    public static final String TAG="MyView";

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG, "dispatchTouchEvent:  " +event.toString());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent:  " +event.toString());
        return super.onTouchEvent(event);
    }
}
