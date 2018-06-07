package com.example.com.xiaoniba987.httpcompoter;

/**
 * Created by 李小龙 on 2018/6/5.
 */

import com.example.com.xiaoniba987.module.HttpModule;
import com.example.com.xiaoniba987.ui.login.LoginActivity;
import com.example.com.xiaoniba987.ui.login_zhuce.LoginActiviti_1;

import dagger.Component;


@Component(modules = HttpModule.class)
public interface HttpComponent {

    //登陆
    void inject(LoginActivity loginActivity);
    void inject(LoginActiviti_1 loginActiviti_1);


}