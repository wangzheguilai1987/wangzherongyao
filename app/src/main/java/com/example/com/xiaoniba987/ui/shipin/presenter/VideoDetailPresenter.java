package com.example.com.xiaoniba987.ui.shipin.presenter;

import com.example.com.xiaoniba987.base.BasePresenter;
import com.example.com.xiaoniba987.bean.VideoDetailBean;
import com.example.com.xiaoniba987.net.VideoDetailApi;
import com.example.com.xiaoniba987.ui.shipin.contract.VideoDetailContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/6/8.
 */

public class VideoDetailPresenter extends BasePresenter<VideoDetailContract.View> implements VideoDetailContract.Presenter {
    private VideoDetailApi videoDetailApi;
    @Inject
    public VideoDetailPresenter(VideoDetailApi videoDetailApi) {
        this.videoDetailApi = videoDetailApi;
    }

    @Override
    public void getVideoDetail(String wid) {
        videoDetailApi.getVideoDetail(wid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoDetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideoDetailBean videoDetailBean) {
                        mView.getVideoDetailSuccess(videoDetailBean);
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