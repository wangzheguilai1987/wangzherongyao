package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.AdBean;
import com.example.com.xiaoniba987.bean.PraiseBean;

import io.reactivex.Observable;

/**
 * Created by Lenovo on 2018/6/10.
 */

public class PraisesApi {
    private static PraisesApi praisesApi;
    private PraisesApiService praisesApiService;

    private PraisesApi(PraisesApiService praisesApiService) {
        this.praisesApiService = praisesApiService;
    }

    public static PraisesApi praises(PraisesApiService praisesApiService) {
        if (praisesApi == null) {
            praisesApi = new PraisesApi(praisesApiService);
        }
        return praisesApi;
    }

    public Observable<PraiseBean> praises(String uid,String wid) {
        return praisesApiService.praises(uid,wid);
    }
}
