package com.example.android.async;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.android.zxingtestapp.R;

public class SyncTaskDemoActivity extends Activity {
    private int today = 0;
    private AsyncTask mAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAsyncTask = new AsyncTask<Object, Void, Boolean>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                showPrograss();
            }

            @Override
            protected Boolean doInBackground(Object... params) {
                // do something in backfround  
                // 长时间的耗时  
                while (true) {
                    if (cancel(true))
                        break;
                    today++;
                    if (today > 100000)
                        break;
                }
                return true;
            }

            @Override
            protected void onPostExecute(Boolean result) {
                super.onPostExecute(result);
                if (result) {
                    // success do something  
                } else {
                    // error  
                }
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
                dismissProgress();
            }
        };
        // 异步执行任务  
        mAsyncTask.execute();
    }

    private void dismissProgress() {
        //取消进度条
    }

    private void showPrograss() {
        //展示进度条
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissProgress();
        mAsyncTask.cancel(true);  //防止内存泄漏
    }
}  