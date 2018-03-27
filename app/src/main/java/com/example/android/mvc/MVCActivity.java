package com.example.android.mvc;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.zxingtestapp.R;

public class MVCActivity extends AppCompatActivity {
    /**
     * View
     */
    private Model model;
    private TextView textView;
    /**
     * Data
     */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            updataView(msg);
        }
    };

    private void updataView(Message msg) {
        switch (msg.what) {
            case 1:
                textView.setText("updata1");
                break;
            case 2:
                textView.setText("updata2");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        initView();
        initData();
        initModel();
    }

    private void initData() {
    }

    private void initModel() {
        model = new Model(mHandler);
    }

    private void initView() {
        textView = (TextView) findViewById(R.id.textView);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.deal(1);
            }
        });
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                model.deal(2);
                return false;
            }
        });
    }
}
