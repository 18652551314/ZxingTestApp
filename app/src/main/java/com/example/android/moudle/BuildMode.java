package com.example.android.moudle;

/**
 * Created by Android on 2018/3/16.
 */

public class BuildMode {
    BuildBean.Builder builder = new BuildBean.Builder();
    BuildBean buildBean = builder
            .name("张三")
            .age(18)
            .height(178.5)
            .weight(67.4)
            .build();
}
