package com.example.com.xiaoniba987.ui.login_zhuce.presenter;

import com.example.com.xiaoniba987.base.BasePresenter;
import com.example.com.xiaoniba987.bean.UserRegisterBean;
import com.example.com.xiaoniba987.net.LoginApi;
import com.example.com.xiaoniba987.ui.login_zhuce.contract.LoginZhuceContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 李小龙 on 2018/6/6.
 */

public class LoginZhucePresenter extends BasePresenter<LoginZhuceContract.View> implements LoginZhuceContract.Presenter {

    private LoginApi loginApi;

    @Inject
    public LoginZhucePresenter(LoginApi loginApi) {
        this.loginApi = loginApi;
    }

    @Override
    public void login_zhuce(final String mobile, String password) {
        loginApi.loginRegister(mobile, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserRegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserRegisterBean userRegisterBean) {
                        if (mView != null) {
                            mView.loginSuccess_zhuce(userRegisterBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
