package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.JokeDetailBean;

import io.reactivex.Observable;

/**
 * Created by Lenovo on 2018/6/8.
 */

public class JokeDetailApi {
    private static JokeDetailApi jokeDetailApi;
    private JokeDetailApiService jokeDetailApiService;

    private JokeDetailApi(JokeDetailApiService jokeDetailApiService) {
        this.jokeDetailApiService = jokeDetailApiService;
    }

    public static JokeDetailApi getJokeDetailApi(JokeDetailApiService jokeDetailApiService) {
        if (jokeDetailApi == null) {
            jokeDetailApi = new JokeDetailApi(jokeDetailApiService);
        }
        return jokeDetailApi;
    }

    public Observable<JokeDetailBean> getJokeDetail(String jid) {
        return jokeDetailApiService.getJokeDetail(jid);
    }
}
