package com.example.com.xiaoniba987.ui.duanzi.presenter;

import com.example.com.xiaoniba987.base.BasePresenter;
import com.example.com.xiaoniba987.bean.JokeDetailBean;
import com.example.com.xiaoniba987.net.JokeDetailApi;
import com.example.com.xiaoniba987.ui.duanzi.contract.JokeDetailContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lenovo on 2018/6/8.
 */

public class JokeDetailPresenter extends BasePresenter<JokeDetailContract.View> implements JokeDetailContract.Presenter{
    private JokeDetailApi jokeDetailApi;
    @Inject
    public JokeDetailPresenter(JokeDetailApi jokeDetailApi) {
        this.jokeDetailApi = jokeDetailApi;
    }

    @Override
    public void getJokeDetail(String jid) {
        jokeDetailApi.getJokeDetail(jid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokeDetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JokeDetailBean jokeDetailBean) {
                        mView.getJokeDetailSuccess(jokeDetailBean);
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
