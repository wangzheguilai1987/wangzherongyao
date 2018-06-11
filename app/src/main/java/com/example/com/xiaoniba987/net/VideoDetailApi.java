package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.VideoDetailBean;

import io.reactivex.Observable;

/**
 * Created by Lenovo on 2018/6/8.
 */

public class VideoDetailApi {
    private static VideoDetailApi videoDetailApi;
    private VideoDetailApiService videoDetailApiService;

    private VideoDetailApi(VideoDetailApiService videoDetailApiService) {
        this.videoDetailApiService = videoDetailApiService;
    }

    public static VideoDetailApi getVideoDetailApi(VideoDetailApiService videoDetailApiService) {
        if (videoDetailApi == null) {
            videoDetailApi = new VideoDetailApi(videoDetailApiService);
        }
        return videoDetailApi;
    }

    public Observable<VideoDetailBean> getVideoDetail(String wid) {
        return videoDetailApiService.getVideoDetail(wid);
    }
}
