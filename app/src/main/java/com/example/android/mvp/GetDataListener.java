package com.example.android.mvp;

public interface GetDataListener {
    /**
     * 请求失败
     */
    void onError();

    /**
     * 请求成功
     */
    void onSuccess();
} 