package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.HotVideosBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Lenovo on 2018/6/7.
 */

public interface HotVideosApiService {
    @GET("quarter/getHotVideos")
    Observable<HotVideosBean> getHotVideos(@Query("page") String page);
}
