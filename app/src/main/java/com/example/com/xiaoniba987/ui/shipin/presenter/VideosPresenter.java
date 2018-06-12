package com.example.com.xiaoniba987.ui.shipin.presenter;

import com.example.com.xiaoniba987.base.BasePresenter;
import com.example.com.xiaoniba987.bean.HotVideosBean;
import com.example.com.xiaoniba987.bean.NearVideosBean;
import com.example.com.xiaoniba987.net.HotVideosApi;
import com.example.com.xiaoniba987.net.NearVideosApi;
import com.example.com.xiaoniba987.ui.shipin.contract.VideosContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/6/7.
 */

public class VideosPresenter extends BasePresenter<VideosContract.View> implements VideosContract.Presenter {
    private HotVideosApi hotVideosApi;
    private NearVideosApi nearVideosApi;

    @Inject
    public VideosPresenter(HotVideosApi hotVideosApi, NearVideosApi nearVideosApi) {
        this.hotVideosApi = hotVideosApi;
        this.nearVideosApi = nearVideosApi;
    }

    @Override
    public void getHotVideos(String page) {
        hotVideosApi.getHotVideos(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotVideosBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotVideosBean hotVideosBean) {
                        mView.getHotVideosSuccess(hotVideosBean);
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
    public void getNearVideos(String page, String latitude, String longitude) {
        nearVideosApi.getNearVideos(page, latitude, longitude)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NearVideosBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NearVideosBean nearVideosBean) {
                        mView.getNearVideosSuccess(nearVideosBean);
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
