package com.example.com.xiaoniba987.ui.duanzi.contract;

import com.example.com.xiaoniba987.base.BaseContract;
import com.example.com.xiaoniba987.bean.JokeDetailBean;

/**
 * Created by Lenovo on 2018/6/8.
 */

public interface JokeDetailContract {
    interface View extends BaseContract.BaseView {
        void getJokeDetailSuccess(JokeDetailBean jokeDetailBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void  getJokeDetail(String jid);
    }
}
