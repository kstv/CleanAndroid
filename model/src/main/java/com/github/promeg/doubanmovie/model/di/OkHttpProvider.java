package com.github.promeg.doubanmovie.model.di;


import com.facebook.stetho.okhttp.StethoInterceptor;
import com.promeg.github.doubanmovie.common.utils.visibility.PackagePrivate;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by guyacong on 2015/9/4.
 */
@PackagePrivate
class OkHttpProvider {

    private static volatile OkHttpClient INSTANCE;

    static OkHttpClient getOkHttpClient() {
        if (INSTANCE == null) {
            synchronized (OkHttpProvider.class) {
                if (INSTANCE == null) {
                    INSTANCE = new OkHttpClient();
                    INSTANCE.networkInterceptors().add(new StethoInterceptor());
                }
            }
        }

        return INSTANCE;
    }


    private OkHttpProvider() {
        // No instances.
    }
}
