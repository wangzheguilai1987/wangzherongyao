package com.example.com.xiaoniba987.net;

import com.example.com.xiaoniba987.bean.CancelFavoriteBean;
import com.example.com.xiaoniba987.bean.PraiseBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Lenovo on 2018/6/10.
 */

public interface CancelFavoriteApiService {
    @GET("quarter/cancelFavorite")
    Observable<CancelFavoriteBean> cancelFavorite(@Query("uid") String uid, @Query("wid") String wid);
}
