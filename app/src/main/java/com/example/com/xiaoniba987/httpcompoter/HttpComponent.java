package com.example.com.xiaoniba987.httpcompoter;

import com.example.com.xiaoniba987.module.HttpModule;
import com.example.com.xiaoniba987.ui.duanzi.DuanZiFragment;
import com.example.com.xiaoniba987.ui.duanzi.JokeDetailActivity;
import com.example.com.xiaoniba987.ui.login.LoginActivity;
import com.example.com.xiaoniba987.ui.login_zhuce.LoginActiviti_1;
import com.example.com.xiaoniba987.ui.qutu.QuTuFragment;
import com.example.com.xiaoniba987.ui.shipin.VideoDetailActivity;
import com.example.com.xiaoniba987.ui.shipin.fragment.FuJinFragment;
import com.example.com.xiaoniba987.ui.shipin.fragment.ReMenShiPinFragment;
import com.example.com.xiaoniba987.ui.tuijian.fragment.GuanZhuFragment;
import com.example.com.xiaoniba987.ui.tuijian.fragment.ReMenFragment;

import dagger.Component;

/**
 * Created by 李小龙 on 2018/6/5.
 */

@Component(modules = HttpModule.class)
public interface HttpComponent {

    //登陆
    void inject(LoginActivity loginActivity);

    void inject(LoginActiviti_1 loginActiviti_1);

    //热门
    void inject(ReMenFragment reMenFragment);

    //段子
    void inject(DuanZiFragment duanZiFragment);

    //关注
    void inject(GuanZhuFragment guanZhuFragment);

    //热门视频
    void inject(ReMenShiPinFragment reMenShiPinFragment);

    //附近视频
    void inject(FuJinFragment fuJinFragment);

    //视频详情
    void inject(VideoDetailActivity videoDetailActivity);

    //端子详情
    void inject(JokeDetailActivity jokeDetailActivity);

    //趣图
    void inject(QuTuFragment quTuFragment);
}