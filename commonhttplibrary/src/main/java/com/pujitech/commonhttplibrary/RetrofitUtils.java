package com.pujitech.commonhttplibrary;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by WangXuguang on 2017/9/20.
 */

public class RetrofitUtils {


    private static long TIME_OUT = 15000;

    /**
     * RetrofitUtils的单例模式
     */
    private static Retrofit.Builder mRetrofit = new Retrofit.Builder()
            .addConverterFactory(FastJsonConverterFactory.create())     //添加Retrofit对fastjson的支持
            .addConverterFactory(ScalarsConverterFactory.create())      //添加Retrofit对String类型的支持
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());  //添加Retrofit对Rxjava的支持


    private static ConcurrentHashMap<String, Object> mRetrofitMap = new ConcurrentHashMap<>();

    private static OkHttpClient.Builder mOkhttpClient = new OkHttpClient.Builder();


    private RetrofitUtils() {

    }


    public static <T extends Object> T getInstance(Class<T> t, String baseUrl) {
        if (mRetrofitMap.containsKey(baseUrl)) {
            return (T) mRetrofitMap.get(baseUrl);
        }
        return initRetrofit(t, baseUrl);
    }

    /**
     * 初始化retrofit的方法
     */
    private static <T extends Object> T initRetrofit(Class<T> t, String baseUrl) {
        T t1 = mRetrofit.client(mOkhttpClient.build()).baseUrl(baseUrl).build().create(t);
        mRetrofitMap.put(baseUrl, t1);
        return t1;
    }

    private static void initOkhttpClient() {
        mOkhttpClient.connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS);
    }

    public static void setTimeOut(long timeOut) {
        TIME_OUT = timeOut;
        initOkhttpClient();
    }

}
