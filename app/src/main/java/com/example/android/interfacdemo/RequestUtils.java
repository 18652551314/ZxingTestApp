package com.example.android.interfacdemo;

import android.app.Activity;

/**
 * Created by Android on 2018/3/16.
 */

public class RequestUtils {
    private RequestListener requestListener;
    private Activity activity;
    public void setListener(RequestListener requestListener, Activity activity) {
        this.requestListener = requestListener;
        this.activity=activity;

    }

    public void requestSuccess(String info) {
        requestListener.success();
    }

    public void requestError(String info) {
        requestListener.error();
    }
}
