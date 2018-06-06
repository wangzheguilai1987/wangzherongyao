package com.example.com.xiaoniba987.base;

/**
 * Created by 李小龙 on 2018/6/5.
 */
/**
 *
 *
 * 所有Presenter的基类，实现BaseContract.BasePresenter的接口
 */

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T>{
     protected T mView;

    @Override
    public void attchView(T view) {
        this.mView=view;
    }

    @Override
    public void detachView() {
        if (mView!=mView){
            mView=null;
        }
    }
}
