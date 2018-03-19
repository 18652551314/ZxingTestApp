package com.example.android;

import android.app.Application;

import com.example.android.screen.DensityHelper;

/**
 * Created by Caodongyao on 2017/8/4.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        new DensityHelper(this, 750).activate();
    }
}
