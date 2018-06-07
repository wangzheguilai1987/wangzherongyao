package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.AdBean;
import com.example.com.xiaoniba987.bean.VideosBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Lenovo on 2018/6/6.
 */

public interface VideosApiService {

    @GET("quarter/getVideos")
    Observable<VideosBean> getVideos(@Query("uid") String uid,@Query("type") String type,@Query("page") String page);
}
