package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.AdBean;
import com.example.com.xiaoniba987.bean.AddFavoriteBean;
import com.example.com.xiaoniba987.bean.PraiseBean;

import io.reactivex.Observable;

/**
 * Created by Lenovo on 2018/6/10.
 */

public class AddFavoriteApi {
    private static AddFavoriteApi addFavoriteApi;
    private AddFavoriteApiService addFavoriteApiService;

    private AddFavoriteApi(AddFavoriteApiService addFavoriteApiService) {
        this.addFavoriteApiService = addFavoriteApiService;
    }

    public static AddFavoriteApi getAddFavoriteApi(AddFavoriteApiService addFavoriteApiService) {
        if (addFavoriteApi == null) {
            addFavoriteApi = new AddFavoriteApi(addFavoriteApiService);
        }
        return addFavoriteApi;
    }

    public Observable<AddFavoriteBean> addFavorite(String uid, String wid) {
        return addFavoriteApiService.addFavorite(uid,wid);
    }
}
