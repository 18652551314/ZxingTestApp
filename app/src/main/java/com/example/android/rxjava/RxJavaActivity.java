package com.example.android.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.zxingtestapp.R;

public class RxJavaActivity extends AppCompatActivity {
    private Contributor contributor = new Contributor();

    private TextView topContributor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        topContributor = (TextView) findViewById(R.id.top_contributor);
    }


}