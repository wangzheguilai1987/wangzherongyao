package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.AdBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Lenovo on 2018/6/6.
 */

public interface AdApiService {

    @GET("ad/getAd")
    Observable<AdBean> getAd();
}
