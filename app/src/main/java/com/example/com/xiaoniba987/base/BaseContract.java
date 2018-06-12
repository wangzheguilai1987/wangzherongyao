package com.example.com.xiaoniba987.base;

/**
 * Created by 李小龙 on 2018/6/5.
 */

public interface BaseContract {

    interface BasePresenter<T extends BaseView> {
        void attchView(T view);  //绑定

        void detachView();//解绑
    }

    interface BaseView {
        void showLoading();//

        void dismissLoading();
    }
}