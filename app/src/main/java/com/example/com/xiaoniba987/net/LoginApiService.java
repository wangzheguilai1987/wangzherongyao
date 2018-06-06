package com.example.com.xiaoniba987.net;

/**
 * Created by 李小龙 on 2018/6/5.
 */

import com.example.com.xiaoniba987.bean.UserBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface LoginApiService {
    //登陆
    @FormUrlEncoded
    @POST("user/login")//post请求
    Observable<UserBean> login(@Field("mobile") String mobile,
                               @Field("password") String password );
   }
