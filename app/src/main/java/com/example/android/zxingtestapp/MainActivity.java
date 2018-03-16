package com.example.android.zxingtestapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_test;
    ImageView img_test;
    Button btn_test, btn_test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxlayout);
        initView();
    }

    private void initView() {
        tv_test = (TextView) findViewById(R.id.tv_test);
        img_test = (ImageView) findViewById(R.id.img_test);
        btn_test = (Button) findViewById(R.id.btn_test);
        btn_test2 = (Button) findViewById(R.id.btn_test2);
        btn_test.setOnClickListener(this);
        btn_test2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test:
                Bitmap bitmap = ZxingUtils.createBitmap("hahahaha");
                img_test.setImageBitmap(bitmap);
                break;

            case R.id.btn_test2:
                new IntentIntegrator(this)
                        .setOrientationLocked(false)
                        .setCaptureActivity(ScanActivity.class) // 设置自定义的activity是ScanActivity
                        .initiateScan(); // 初始化扫描

                break;


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(this, "内容为空", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "扫描成功", Toast.LENGTH_LONG).show();
                // ScanResult 为 获取到的字符串
                String ScanResult = intentResult.getContents();
                tv_test.setText(ScanResult);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }



}
