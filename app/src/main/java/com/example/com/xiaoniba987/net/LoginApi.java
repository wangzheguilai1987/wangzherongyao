package com.example.com.xiaoniba987.net;

/**
 * Created by 李小龙 on 2018/6/5.
 */

import com.example.com.xiaoniba987.bean.UserBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;



public class LoginApi {
    private static LoginApi loginApi;
    private LoginApiService loginApiService;

    private LoginApi(LoginApiService loginApiService) {
        this.loginApiService = loginApiService;

    }

    public static LoginApi getLoginApi(LoginApiService loginApiService) {
        if (loginApi == null) {
            loginApi = new LoginApi(loginApiService);
        }
        return loginApi;
    }

    //
    public Observable<UserBean> login(String mobile, String passwod) {
        return loginApiService.login(mobile, passwod);
    }

}