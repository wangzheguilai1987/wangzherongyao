package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.AdBean;
import com.example.com.xiaoniba987.bean.JokesBean;

import io.reactivex.Observable;

/**
 * Created by Lenovo on 2018/6/6.
 */

public class JokesApi {
    private static JokesApi jokesApi;
    private JokesApiService jokesApiService;

    private JokesApi(JokesApiService jokesApiService) {
        this.jokesApiService = jokesApiService;
    }

    public static JokesApi getJokesApi(JokesApiService jokesApiService) {
        if (jokesApi == null) {
            jokesApi = new JokesApi(jokesApiService);
        }
        return jokesApi;
    }

    public Observable<JokesBean> getJokes(String page) {
        return jokesApiService.getJokes(page);
    }
}
