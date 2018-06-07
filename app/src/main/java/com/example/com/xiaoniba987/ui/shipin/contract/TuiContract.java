package com.example.com.xiaoniba987.ui.shipin.contract;

import com.example.com.xiaoniba987.base.BaseContract;
import com.example.com.xiaoniba987.bean.AdBean;
import com.example.com.xiaoniba987.bean.VideosBean;

/**
 * Created by Lenovo on 2018/6/6.
 */

public interface TuiContract {
    interface View extends BaseContract.BaseView{
        void getAdSuccess(AdBean adBean);
        void getVideosSuccess(VideosBean videosBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View> {
        void getAd();
        void getVideos(String uid, String type, String page);
    }
}
