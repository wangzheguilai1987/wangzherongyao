package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.AdBean;

import io.reactivex.Observable;

/**
 * Created by Lenovo on 2018/6/6.
 */

public class AdApi {
    private static AdApi adApi;
    private AdApiService adApiService;

    private AdApi(AdApiService adApiService) {
        this.adApiService = adApiService;
    }

    public static AdApi getAdApi(AdApiService adApiService) {
        if (adApi == null) {
            adApi = new AdApi(adApiService);
        }
        return adApi;
    }

    public Observable<AdBean> getAd() {
        return adApiService.getAd();
    }
}
