package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.CancelFavoriteBean;
import com.example.com.xiaoniba987.bean.PraiseBean;

import io.reactivex.Observable;

/**
 * Created by Lenovo on 2018/6/10.
 */

public class CancelFavoriteApi {
    private static CancelFavoriteApi cancelFavoriteApi;
    private CancelFavoriteApiService cancelFavoriteApiService;

    private CancelFavoriteApi(CancelFavoriteApiService cancelFavoriteApiService) {
        this.cancelFavoriteApiService = cancelFavoriteApiService;
    }

    public static CancelFavoriteApi cancelFavorite(CancelFavoriteApiService cancelFavoriteApiService) {
        if (cancelFavoriteApi == null) {
            cancelFavoriteApi = new CancelFavoriteApi(cancelFavoriteApiService);
        }
        return cancelFavoriteApi;
    }

    public Observable<CancelFavoriteBean> cancelFavorite(String uid, String wid) {
        return cancelFavoriteApiService.cancelFavorite(uid,wid);
    }
}
