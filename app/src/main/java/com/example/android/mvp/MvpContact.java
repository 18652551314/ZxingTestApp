package com.example.android.mvp;

public interface MvpContact {
    interface Presenter {
        /**
         * 获取数据
         */
        void getData();
    }

    interface View {
        /**
         * 更新数据到View
         */
        void showData();

        /**
         * 弹出错误提示
         */
        void showError();
    }
} 