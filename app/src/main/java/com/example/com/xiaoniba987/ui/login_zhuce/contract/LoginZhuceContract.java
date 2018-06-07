package com.example.com.xiaoniba987.ui.login_zhuce.contract;

import com.example.com.xiaoniba987.base.BaseContract;
import com.example.com.xiaoniba987.bean.UserBean;
import com.example.com.xiaoniba987.bean.UserRegisterBean;
import com.example.com.xiaoniba987.ui.login.contract.LoginContract;

/**
 * Created by 李小龙 on 2018/6/6.
 */

public interface LoginZhuceContract {

    //泛型  实现 P层和 View层关联
    interface Presenter extends BaseContract.BasePresenter<LoginZhuceContract.View>{

        //登陆方法    需要两个参数
        void  login_zhuce(String mobile,String password);

    }
    interface View extends BaseContract.BaseView{

        void loginSuccess_zhuce(UserRegisterBean userRegisterBean);  //登陆bean包
    }

}
