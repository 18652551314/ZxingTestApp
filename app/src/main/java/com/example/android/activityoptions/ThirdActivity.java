package com.example.android.activityoptions;

import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.zxingtestapp.R;

public class ThirdActivity extends AppCompatActivity {
    private GridView list;
    private int []arr={1,2,3,4,5,6,7,8,9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.activity_third);

        list = (GridView) findViewById(R.id.list);
        list.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return arr.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                if (convertView == null) {
                    convertView = LayoutInflater.from(ThirdActivity.this).inflate(R.layout.main_item, null);
                }
                TextView text= (TextView) convertView.findViewById(R.id.textview);
                text.setText(arr[position]+"");
                text.setBackgroundColor(position%2==0? Color.GREEN:Color.CYAN);
                return convertView;
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
