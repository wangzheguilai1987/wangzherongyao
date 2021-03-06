package com.example.com.xiaoniba987.module;

/**
 * Created by 李小龙 on 2018/6/5.
 */


import com.example.com.xiaoniba987.net.AdApi;
import com.example.com.xiaoniba987.net.AdApiService;
import com.example.com.xiaoniba987.net.AddFavoriteApi;
import com.example.com.xiaoniba987.net.AddFavoriteApiService;
import com.example.com.xiaoniba987.net.Api;
import com.example.com.xiaoniba987.net.CancelFavoriteApi;
import com.example.com.xiaoniba987.net.CancelFavoriteApiService;
import com.example.com.xiaoniba987.net.HotVideosApi;
import com.example.com.xiaoniba987.net.HotVideosApiService;
import com.example.com.xiaoniba987.net.JokeDetailApi;
import com.example.com.xiaoniba987.net.JokeDetailApiService;
import com.example.com.xiaoniba987.net.JokesApi;
import com.example.com.xiaoniba987.net.JokesApiService;
import com.example.com.xiaoniba987.net.LoginApi;
import com.example.com.xiaoniba987.net.LoginApiService;
import com.example.com.xiaoniba987.net.NearVideosApi;
import com.example.com.xiaoniba987.net.NearVideosApiService;
import com.example.com.xiaoniba987.net.PraisesApi;
import com.example.com.xiaoniba987.net.PraisesApiService;
import com.example.com.xiaoniba987.net.VideoDetailApi;
import com.example.com.xiaoniba987.net.VideoDetailApiService;
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

    @Provides
        //不需要拦截器
    HotVideosApi provideHotVideosApi() {

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
        HotVideosApiService hotVideosApiService = retrofit.create(HotVideosApiService.class);


        return HotVideosApi.getHotVideosApi(hotVideosApiService);
    }

    @Provides
        //不需要拦截器
    NearVideosApi provideNearVideosApi() {

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
        NearVideosApiService nearVideosApiService = retrofit.create(NearVideosApiService.class);


        return NearVideosApi.getNearVideosApi(nearVideosApiService);
    }

    @Provides
        //不需要拦截器
    VideoDetailApi provideVideoDetailApi() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.LOGIN_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)//用自己的设置读取和链接超时时间'

                .build();
        VideoDetailApiService videoDetailApiService = retrofit.create(VideoDetailApiService.class);


        return VideoDetailApi.getVideoDetailApi(videoDetailApiService);
    }

    @Provides
        //不需要拦截器
    JokeDetailApi provideJokeDetailApi() {

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
        JokeDetailApiService jokeDetailApiService = retrofit.create(JokeDetailApiService.class);


        return JokeDetailApi.getJokeDetailApi(jokeDetailApiService);
    }

    @Provides
        //不需要拦截器
    PraisesApi providePraisesApi() {

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
        PraisesApiService praisesApiService = retrofit.create(PraisesApiService.class);


        return PraisesApi.praises(praisesApiService);
    }

    @Provides
        //不需要拦截器
    AddFavoriteApi provideAddFavoriteApi() {

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
        AddFavoriteApiService addFavoriteApiService = retrofit.create(AddFavoriteApiService.class);

        return AddFavoriteApi.getAddFavoriteApi(addFavoriteApiService);
    }

    @Provides
        //不需要拦截器
    CancelFavoriteApi provideCancelFavoriteApi() {

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
        CancelFavoriteApiService cancelFavoriteApiService = retrofit.create(CancelFavoriteApiService.class);

        return CancelFavoriteApi.cancelFavorite(cancelFavoriteApiService);
    }

}
