package com.example.com.xiaoniba987.module;

/**
 * Created by 李小龙 on 2018/6/5.
 */


import com.example.com.xiaoniba987.net.AdApi;
import com.example.com.xiaoniba987.net.AdApiService;
import com.example.com.xiaoniba987.net.Api;
import com.example.com.xiaoniba987.net.JokesApi;
import com.example.com.xiaoniba987.net.JokesApiService;
import com.example.com.xiaoniba987.net.LoginApi;
import com.example.com.xiaoniba987.net.LoginApiService;
import com.example.com.xiaoniba987.net.VideosApi;
import com.example.com.xiaoniba987.net.VideosApiService;
import com.example.com.xiaoniba987.utils.CommonParamsInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class HttpModule {

    @Provides
        //不需要拦截器
    LoginApi provideLoginApi() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.LOGIN_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)//用自己的设置读取和链接超时时间
                .build();
        LoginApiService loginApiService = retrofit.create(LoginApiService.class);


        return LoginApi.getLoginApi(loginApiService);
    }

   /* @Provides  //需要拦截器
    AddInterceptor_ addInterceptor_(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new MyInterceptor())//拦截器
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.LOGIN_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)//用自己的设置读取和链接超时时间
                .build();
        AddInterceptor_Service addInterceptor_service = retrofit.create(AddInterceptor_Service.class);

        return AddInterceptor_.getAddInterceptor_(addInterceptor_service);

    }*/
   @Provides
   //不需要拦截器
   AdApi provideAdApi() {

       OkHttpClient okHttpClient = new OkHttpClient.Builder()
               .writeTimeout(20, TimeUnit.SECONDS)
               .readTimeout(20, TimeUnit.SECONDS)
               .connectTimeout(10, TimeUnit.SECONDS)
               .build();

       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl(Api.LOGIN_URL)
               .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
               .addConverterFactory(GsonConverterFactory.create())
               .client(okHttpClient)//用自己的设置读取和链接超时时间
               .build();
       AdApiService adApiService = retrofit.create(AdApiService.class);


       return AdApi.getAdApi(adApiService);
   }
    @Provides
        //不需要拦截器
    VideosApi provideVideosApi() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new CommonParamsInterceptor())//拦截器
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.LOGIN_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)//用自己的设置读取和链接超时时间'

                .build();
        VideosApiService videosApiService = retrofit.create(VideosApiService.class);


        return VideosApi.getVideosApi(videosApiService);
    }

    @Provides
        //不需要拦截器
    JokesApi provideJokesApi() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new CommonParamsInterceptor())//拦截器
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.LOGIN_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)//用自己的设置读取和链接超时时间'

                .build();
        JokesApiService jokesApiService = retrofit.create(JokesApiService.class);


        return JokesApi.getJokesApi(jokesApiService);
    }
}
