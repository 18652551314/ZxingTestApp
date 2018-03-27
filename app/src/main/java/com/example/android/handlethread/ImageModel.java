package com.example.android.handlethread;

import android.graphics.Bitmap;

/**
 * Created by Android on 2018/3/27.
 */
public class ImageModel {
    Bitmap bitmap;
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
