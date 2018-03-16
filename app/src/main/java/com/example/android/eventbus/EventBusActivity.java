package com.example.android.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.android.zxingtestapp.R;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.ThreadMode;

public class EventBusActivity extends AppCompatActivity {
    private Button btn;
    EventBus eventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        btn = (Button) findViewById(R.id.btn);
        //注册订阅者
        eventBus = new EventBus();
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销注册
        EventBus.getDefault().unregister(this);
    }

    public void Done() {
        EventBus.getDefault().post(new UserEvent("Mr.sorrow", "123456"));
    }


}