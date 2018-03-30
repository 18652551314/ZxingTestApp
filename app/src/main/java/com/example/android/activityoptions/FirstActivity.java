package com.example.android.activityoptions;


import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;

import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.zxingtestapp.R;

public class FirstActivity extends AppCompatActivity {
    private ImageView imgView;
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Transition explode = TransitionInflater.from(this).inflateTransition(R.transition.explode);
//        //退出时使用
//        getWindow().setExitTransition(explode);
//        // 第一次进入时使用
//        getWindow().setEnterTransition(explode);
//        // 再次进入时使用
//        getWindow().setReenterTransition(explode);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        imgView = (ImageView) findViewById(R.id.ImgView1);
        txtView = (TextView) findViewById(R.id.TxtView1);
        final Pair<View, String> imgViewPair = Pair.create((View) imgView, getString(R.string.tu));
        final Pair<View, String> txtViewPair = Pair.create((View) txtView, getString(R.string.zi));
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(FirstActivity.this, new Pair[]{imgViewPair, txtViewPair});
                ActivityCompat.startActivity(FirstActivity.this, new Intent(FirstActivity.this, SecondActivity.class), compat.toBundle());
            }
        });

    }
}
