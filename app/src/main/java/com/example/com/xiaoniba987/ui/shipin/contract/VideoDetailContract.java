package com.example.com.xiaoniba987.ui.shipin.contract;

import com.example.com.xiaoniba987.base.BaseContract;
import com.example.com.xiaoniba987.bean.VideoDetailBean;

/**
 * Created by Lenovo on 2018/6/8.
 */

public interface VideoDetailContract {
    interface View extends BaseContract.BaseView {
        void getVideoDetailSuccess(VideoDetailBean videoDetailBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getVideoDetail(String wid);
    }
}
