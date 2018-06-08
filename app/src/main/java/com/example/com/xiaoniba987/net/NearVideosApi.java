package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.AdBean;
import com.example.com.xiaoniba987.bean.NearVideosBean;

import io.reactivex.Observable;

/**
 * Created by Lenovo on 2018/6/7.
 */

public class NearVideosApi {
    private static NearVideosApi nearVideosApi;
    private NearVideosApiService nearVideosApiService;

    private NearVideosApi(NearVideosApiService nearVideosApiService) {
        this.nearVideosApiService = nearVideosApiService;
    }

    public static NearVideosApi getNearVideosApi(NearVideosApiService nearVideosApiService) {
        if (nearVideosApi == null) {
            nearVideosApi = new NearVideosApi(nearVideosApiService);
        }
        return nearVideosApi;
    }

    public Observable<NearVideosBean> getNearVideos(String page,String latitude,String longitude) {
        return nearVideosApiService.getNearVideos(page,latitude,longitude);
    }
}
