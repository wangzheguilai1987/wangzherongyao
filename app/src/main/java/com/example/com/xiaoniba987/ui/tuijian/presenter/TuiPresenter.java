package com.example.com.xiaoniba987.ui.tuijian.presenter;

import android.util.Log;

import com.example.com.xiaoniba987.base.BasePresenter;
import com.example.com.xiaoniba987.bean.AdBean;
import com.example.com.xiaoniba987.bean.VideosBean;
import com.example.com.xiaoniba987.net.AdApi;
import com.example.com.xiaoniba987.net.VideosApi;
import com.example.com.xiaoniba987.ui.tuijian.contract.TuiContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/6/6.
 */

public class TuiPresenter extends BasePresenter<TuiContract.View> implements TuiContract.Presenter{
    private AdApi adApi;
    private VideosApi videosApi;
    @Inject
    public TuiPresenter(AdApi adApi, VideosApi videosApi) {
        this.adApi = adApi;
        this.videosApi = videosApi;
    }

    @Override
    public void getAd() {
        adApi.getAd().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AdBean adBean) {
                        Log.d("sss",adBean.getData().get(0).getTitle());
                        mView.getAdSuccess(adBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getVideos(String uid, String type, String page) {
        videosApi.getVideos(uid,type,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideosBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideosBean videosBean) {
                        mView.getVideosSuccess(videosBean);
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
