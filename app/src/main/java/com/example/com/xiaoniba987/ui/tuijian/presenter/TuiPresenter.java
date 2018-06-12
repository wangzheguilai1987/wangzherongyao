package com.example.com.xiaoniba987.ui.tuijian.presenter;

import android.util.Log;

import com.example.com.xiaoniba987.base.BasePresenter;
import com.example.com.xiaoniba987.bean.AdBean;
import com.example.com.xiaoniba987.bean.AddFavoriteBean;
import com.example.com.xiaoniba987.bean.CancelFavoriteBean;
import com.example.com.xiaoniba987.bean.PraiseBean;
import com.example.com.xiaoniba987.bean.VideosBean;
import com.example.com.xiaoniba987.net.AdApi;
import com.example.com.xiaoniba987.net.AddFavoriteApi;
import com.example.com.xiaoniba987.net.CancelFavoriteApi;
import com.example.com.xiaoniba987.net.PraisesApi;
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

public class TuiPresenter extends BasePresenter<TuiContract.View> implements TuiContract.Presenter {
    private AdApi adApi;
    private VideosApi videosApi;
    private PraisesApi praiseApi;
    private AddFavoriteApi addFavoriteApi;
    private CancelFavoriteApi cancelFavoriteApi;

    @Inject
    public TuiPresenter(AdApi adApi, VideosApi videosApi, PraisesApi praiseApi, AddFavoriteApi addFavoriteApi, CancelFavoriteApi cancelFavoriteApi) {
        this.adApi = adApi;
        this.videosApi = videosApi;
        this.praiseApi = praiseApi;
        this.addFavoriteApi = addFavoriteApi;
        this.cancelFavoriteApi = cancelFavoriteApi;
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
        videosApi.getVideos(uid, type, page)
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

    @Override
    public void praise(String uid, String wid) {
        praiseApi.praises(uid, wid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PraiseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PraiseBean praiseBean) {
                        String msg = praiseBean.getMsg();
                        mView.praiseSuccess(msg);
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
    public void addFavorite(String uid, String wid) {
        addFavoriteApi.addFavorite(uid, wid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddFavoriteBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AddFavoriteBean addFavoriteBean) {
                        String msg = addFavoriteBean.getMsg();
                        mView.addFavoriteSuccess(msg);
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
    public void cancelFavorite(String uid, String wid) {
        cancelFavoriteApi.cancelFavorite(uid, wid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CancelFavoriteBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CancelFavoriteBean cancelFavoriteBean) {
                        String msg = cancelFavoriteBean.getMsg();
                        mView.cancelFavoriteSuccess(msg);
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
