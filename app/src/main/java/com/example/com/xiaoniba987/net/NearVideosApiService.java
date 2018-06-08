package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.NearVideosBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Lenovo on 2018/6/7.
 */

public interface NearVideosApiService {
    @GET("quarter/getNearVideos")
    Observable<NearVideosBean> getNearVideos(@Query("page") String page,@Query("latitude") String latitude,@Query("longitude") String longitude);
}
