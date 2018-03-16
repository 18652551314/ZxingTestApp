package com.example.android.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.zxingtestapp.R;

class ViewHoderAdaapters extends RecyclerView.Adapter{
    private Context context;
    private String[]datas;


    public ViewHoderAdaapters(RecycleViewActivity mainActivity, String[] data) {
        this.context = mainActivity;
        this.datas = data;
    }

    @Override
    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHoders viewHoders = new ViewHoders(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,null));
        return viewHoders;
    }

    @Override
    //填充onCreateViewHolder方法返回的holder中的控件
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHoders) holder).tv.setText(datas[position]+position);
    }

    @Override
    public int getItemCount() {
        return datas.length;
    }
    //自定义ViewHolder,
    /*
    * RecylerView封装了viewholder的回收复用，也就是说RecylerView标准化了ViewHolder，编写Adapter面向的是ViewHolder而不再是View了
    * */
    class ViewHoders extends RecyclerView.ViewHolder{
        private TextView tv;

        public ViewHoders(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.textview);
        }
    }

}