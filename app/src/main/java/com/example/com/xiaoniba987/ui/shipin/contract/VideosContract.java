package com.example.com.xiaoniba987.ui.shipin.contract;

import com.example.com.xiaoniba987.base.BaseContract;
import com.example.com.xiaoniba987.bean.AdBean;
import com.example.com.xiaoniba987.bean.HotVideosBean;
import com.example.com.xiaoniba987.bean.NearVideosBean;
import com.example.com.xiaoniba987.bean.VideosBean;

/**
 * Created by Lenovo on 2018/6/7.
 */

public interface VideosContract {
    interface View extends BaseContract.BaseView{
        void getHotVideosSuccess(HotVideosBean hotVideosBean);
        void getNearVideosSuccess(NearVideosBean nearVideosBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View> {
        void getHotVideos(String page);
        void getNearVideos(String page,String latitude,String longitude);
    }
}
