package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.AdBean;
import com.example.com.xiaoniba987.bean.VideosBean;

import io.reactivex.Observable;

/**
 * Created by Lenovo on 2018/6/6.
 */

public class VideosApi {
    private static VideosApi videosApi;
    private VideosApiService videosApiService;

    private VideosApi(VideosApiService videosApiService) {
        this.videosApiService = videosApiService;
    }

    public static VideosApi getVideosApi(VideosApiService videosApiService) {
        if (videosApi == null) {
            videosApi = new VideosApi(videosApiService);
        }
        return videosApi;
    }

    public Observable<VideosBean> getVideos(String uid,String type,String page) {
        return videosApiService.getVideos(uid,type,page);
    }
}
