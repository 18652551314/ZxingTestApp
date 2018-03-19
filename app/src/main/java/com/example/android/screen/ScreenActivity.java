package com.example.android.screen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.android.zxingtestapp.R;


public class ScreenActivity extends AppCompatActivity {
    public final static int COMPLEX_UNIT_PX = 0;
    public final static int COMPLEX_UNIT_DIP = 1;
    public final static int COMPLEX_UNIT_SP = 2;
    public final static int COMPLEX_UNIT_PT = 3;
    public final static int COMPLEX_UNIT_IN = 4;
    public final static int COMPLEX_UNIT_MM = 5;
    private Context mContext;
    private DisplayMetrics metrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
//        mContext = this;
//        metrics = mContext.getResources().getDisplayMetrics();
    }

    public void gotoNormal(View view) {
        startActivity(new Intent(this, NormalActivity.class));
    }

    public void gotoRude(View view) {
        startActivity(new Intent(this, RudeActivity.class));
    }

    public static float applyDimension(int unit, float value, DisplayMetrics metrics) {
        switch (unit) {
            case COMPLEX_UNIT_PX:
                return value;
            case COMPLEX_UNIT_DIP:
                return value * metrics.density;
            case COMPLEX_UNIT_SP:
                return value * metrics.scaledDensity;
            case COMPLEX_UNIT_PT:
                return value * metrics.xdpi * (1.0f / 72);
            case COMPLEX_UNIT_IN:
                return value * metrics.xdpi;
            case COMPLEX_UNIT_MM:
                return value * metrics.xdpi * (1.0f / 25.4f);
        }
        return 0;
    }


}