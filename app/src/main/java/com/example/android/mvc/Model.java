package com.example.android.mvc;


import android.os.Handler;
import android.os.Message;

/**
 * Created by Android on 2018/3/23.
 */

public class Model {
    private Handler handler;

    public Model(Handler handler) {
        this.handler = handler;
    }

    public void deal(int eventType) {
        switch (eventType) {
            case 1:
                handler.sendEmptyMessage(1);
                break;
            case 2:
                handler.sendEmptyMessage(2);
                break;
        }

    }
}
