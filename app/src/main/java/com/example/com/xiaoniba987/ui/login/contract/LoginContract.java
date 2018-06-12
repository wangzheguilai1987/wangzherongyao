package com.example.com.xiaoniba987.ui.login.contract;

import com.example.com.xiaoniba987.base.BaseContract;
import com.example.com.xiaoniba987.bean.UserBean;

/**
 * Created by 李小龙 on 2018/6/6.
 */

public interface LoginContract {

    //泛型  实现 P层和 View层关联
    interface Presenter extends BaseContract.BasePresenter<View> {

        //登陆方法    需要两个参数
        void login(String mobile, String password);

    }

    interface View extends BaseContract.BaseView {

        void loginSuccess(UserBean userBean);  //登陆bean包

        void loginError(String err);  //登陆bean包
    }
}
