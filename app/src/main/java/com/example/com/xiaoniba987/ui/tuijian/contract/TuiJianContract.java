package com.example.com.xiaoniba987.ui.tuijian.contract;

import com.example.com.xiaoniba987.base.BaseContract;
import com.example.com.xiaoniba987.bean.UserBean;

/**
 * Created by 李小龙 on 2018/6/5.
 */

public interface TuiJianContract {

    //泛型  实现 P层和 View层关联
    interface Presenter extends BaseContract.BasePresenter<View> {

        //推荐方法    需要两个参数
        void tuijian(String mobile, String password);

    }

    interface View extends BaseContract.BaseView {

        void loginSuccess(UserBean userBean);  //登陆bean包
    }
}
