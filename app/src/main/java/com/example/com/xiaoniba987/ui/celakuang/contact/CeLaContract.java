package com.example.com.xiaoniba987.ui.celakuang.contact;

import com.example.com.xiaoniba987.base.BaseContract;
import com.example.com.xiaoniba987.bean.UserGuanzhu;

/**
 * Created by 李小龙 on 2018/6/7.
 */

public interface CeLaContract {
    //泛型  实现 P层和 View层关联
    interface Presenter extends BaseContract.BasePresenter<View> {

        //登陆方法    需要两个参数
        void celakuang(String mobile, String password);

    }

    interface View extends BaseContract.BaseView {

        void celaSuccess(UserGuanzhu userGuanzhu);  //登陆bean包
    }
}
