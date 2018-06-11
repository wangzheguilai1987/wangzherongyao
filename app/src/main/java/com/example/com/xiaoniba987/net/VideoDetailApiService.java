package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.VideoDetailBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Lenovo on 2018/6/8.
 */

public interface VideoDetailApiService {
    @GET("quarter/getVideoDetail")
    Observable<VideoDetailBean> getVideoDetail(@Query("wid") String wid);

}
