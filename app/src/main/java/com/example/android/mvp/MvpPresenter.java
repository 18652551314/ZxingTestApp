package com.example.android.mvp;

public class MvpPresenter implements MvpContact.Presenter {
    MvpContact.View view;
    MvpModel model;

    public MvpPresenter(MvpContact.View mView) {
        view = mView;
        model = new MvpModel();
    }

    @Override
    public void getData() {
        model.getData(new GetDataListener() {
            @Override
            public void onError() {
//请求失败弹出提示等 
                view.showError();
            }

            @Override
            public void onSuccess() {
//请求成功更新数据到UI 
                view.showData();
            }
        });
    }
} 