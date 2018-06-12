package com.example.com.xiaoniba987.ui.duanzi.presenter;

import com.example.com.xiaoniba987.base.BasePresenter;
import com.example.com.xiaoniba987.bean.JokesBean;
import com.example.com.xiaoniba987.net.JokesApi;
import com.example.com.xiaoniba987.ui.duanzi.contract.DuanZiContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/6/6.
 */

public class DuanZiPresenter extends BasePresenter<DuanZiContract.View> implements DuanZiContract.Presenter {
    private JokesApi jokesApi;

    @Inject
    public DuanZiPresenter(JokesApi jokesApi) {
        this.jokesApi = jokesApi;
    }

    @Override
    public void getJokes(String page) {
        jokesApi.getJokes(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokesBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JokesBean jokesBean) {
                        mView.getJokesSuccess(jokesBean);
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
