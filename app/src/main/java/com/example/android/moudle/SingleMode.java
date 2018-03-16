package com.example.android.moudle;

/**
 * Created by Android on 2018/3/16.
 */

public class SingleMode {
    private volatile static SingleMode instance;
    /** Returns singleton class instance */
    public static SingleMode getInstance() {
        if (instance == null) {
            synchronized (SingleMode.class) {
                if (instance == null) {
                    instance = new SingleMode();
                }
            }
        }
        return instance;
    }
}
