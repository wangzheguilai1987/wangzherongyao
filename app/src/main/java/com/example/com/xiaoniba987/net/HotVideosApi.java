package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.AdBean;
import com.example.com.xiaoniba987.bean.HotVideosBean;

import io.reactivex.Observable;

/**
 * Created by Lenovo on 2018/6/7.
 */

public class HotVideosApi {
    private static HotVideosApi hotVideosApi;
    private HotVideosApiService hotVideosApiService;

    private HotVideosApi(HotVideosApiService hotVideosApiService) {
        this.hotVideosApiService = hotVideosApiService;
    }

    public static HotVideosApi getHotVideosApi(HotVideosApiService hotVideosApiService) {
        if (hotVideosApi == null) {
            hotVideosApi = new HotVideosApi(hotVideosApiService);
        }
        return hotVideosApi;
    }

    public Observable<HotVideosBean> getHotVideos(String page) {
        return hotVideosApiService.getHotVideos(page);
    }
}
