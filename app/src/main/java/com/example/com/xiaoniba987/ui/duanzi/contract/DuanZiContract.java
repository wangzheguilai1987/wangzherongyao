package com.example.com.xiaoniba987.ui.duanzi.contract;

import com.example.com.xiaoniba987.base.BaseContract;
import com.example.com.xiaoniba987.bean.AdBean;
import com.example.com.xiaoniba987.bean.JokesBean;

/**
 * Created by Lenovo on 2018/6/6.
 */

public interface DuanZiContract {
    interface View extends BaseContract.BaseView {
        void getJokesSuccess(JokesBean jokesBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void  getJokes(String page);
    }
}
