package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.JokesBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Lenovo on 2018/6/6.
 */

public interface JokesApiService {
    @GET("quarter/getJokes")
    Observable<JokesBean> getJokes(@Query("page") String page);
}
