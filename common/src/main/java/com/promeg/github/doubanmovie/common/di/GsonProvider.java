package com.promeg.github.doubanmovie.common.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.promeg.github.doubanmovie.common.Constants;
import com.promeg.github.doubanmovie.common.utils.gson.AutoValueTypeAdapterFactory;
import com.promeg.github.doubanmovie.common.utils.visibility.PackagePrivate;

/**
 * Provide Singleton Gson.
 *
 * Created by guyacong on 2015/4/14.
 */
@PackagePrivate
class GsonProvider {

    private Gson mGson;


    private GsonProvider() {
        mGson = new GsonBuilder()
                .setDateFormat(Constants.DATE_FORMAT)
                .registerTypeAdapterFactory(new AutoValueTypeAdapterFactory())
                .setPrettyPrinting().create();
    }

    public static GsonProvider getInstance() {
        return GsonProviderHolder.instance;
    }

    private static class GsonProviderHolder {
        private static final GsonProvider instance = new GsonProvider();
    }

    public Gson getGson() {
        return mGson;
    }
}
