package com.example.android.qianghongbao;



import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import com.example.android.zxingtestapp.R;


public class QhbActivity extends AppCompatActivity implements View.OnClickListener{



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }



    @Override

    public void onClick(View view) {

        Intent intent = new Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS);

        startActivity(intent);

    }





}