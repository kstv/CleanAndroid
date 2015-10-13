package com.github.promeg.doubanmovie.model.di;

import com.google.gson.Gson;

import com.facebook.stetho.okhttp.StethoInterceptor;
import com.promeg.github.doubanmovie.common.utils.visibility.PackagePrivate;
import com.squareup.okhttp.OkHttpClient;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Provide Singleton RestAdapter and cached rest Apis.
 *
 * Created by guyacong on 2015/9/4.
 */
@PackagePrivate
class RetrofitProvider {

    private Retrofit mRetrofit;

    private Map<String, Object> mRestApiInstances = new HashMap<String, Object>();

    private static volatile RetrofitProvider INSTANCE;

    public static RetrofitProvider getInstance(Gson gson, OkHttpClient client) {
        if (INSTANCE == null) {
            synchronized (StorIOProvider.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RetrofitProvider(gson, client);
                }
            }
        }

        return INSTANCE;
    }

    private RetrofitProvider(Gson gson, OkHttpClient client) {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
    }


    /** thread safe, ensure every Api will be created only once **/
    synchronized <T> T getRestApi(@NonNull Class<T> clazz) {
        T client;
        if ((client = (T) mRestApiInstances.get(clazz.getCanonicalName())) != null) {
            return client;
        }
        client = mRetrofit.create(clazz);
        mRestApiInstances.put(clazz.getCanonicalName(), client);
        return client;
    }
}
