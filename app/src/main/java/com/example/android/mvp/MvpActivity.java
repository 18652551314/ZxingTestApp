package com.example.android.mvp;

import android.app.Activity;
import android.os.Bundle;

import com.example.android.zxingtestapp.R;

public class MvpActivity extends Activity implements MvpContact.View {
    MvpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        presenter = new MvpPresenter(this);
//请求数据 
        presenter.getData();
    }

    @Override
    public void showData() {
    }

    @Override
    public void showError() {
    }
} 