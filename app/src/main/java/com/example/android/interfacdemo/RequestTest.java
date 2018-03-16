package com.example.android.interfacdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Android on 2018/3/16.
 */

public class RequestTest extends Activity implements RequestListener {
    RequestUtils requestUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestUtils = new RequestUtils();
        requestUtils.setListener(this,this);

    }

    @Override
    public void success() {
        requestUtils.requestError("success");
    }

    @Override
    public void error() {
        requestUtils.requestError("error");
    }
}
