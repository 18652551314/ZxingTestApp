package com.example.android.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.zxingtestapp.R;

public class RecycleViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private String[] data ={"我是熊大","我是熊二","我是熊仨","我是熊四","我是熊五","我是熊六","我是熊大",
            "我是熊大","我是熊大","我是熊大","我是熊大","我是熊二","我是熊仨","我是熊四","我是熊五","我是熊六"
            ,"我是熊大","我是熊大","我是熊大","我是熊大"};
    private ViewHoderAdaapters adaapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        recyclerView= (RecyclerView) findViewById(R.id.recycler_View);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ViewHoderAdaapters(RecycleViewActivity.this,data));
    }

}
