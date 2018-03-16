package com.example.android.mvp;

public class MvpModel {
    public void getData(GetDataListener listener) {
//执行具体的请求 
//请求失败 
        listener.onError();
//请求成功 
        listener.onSuccess();
    }
} 
