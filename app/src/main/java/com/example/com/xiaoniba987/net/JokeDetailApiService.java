package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.JokeDetailBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Lenovo on 2018/6/8.
 */

public interface JokeDetailApiService {
    @GET("quarter/getJokeDetail")
    Observable<JokeDetailBean> getJokeDetail(@Query("jid") String jid);
}
