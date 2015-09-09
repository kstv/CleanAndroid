package com.github.promeg.doubanmovie.model.utils;

import com.google.gson.Gson;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.reflect.Type;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by guyacong on 2015/9/5.
 */
public class DbUtils {
    public static @NonNull String toStringSafely(@NonNull Gson gson, @Nullable Object src, @NonNull Type typeOfSrc) {
        checkNotNull(gson);
        checkNotNull(typeOfSrc);

        if(src == null){
            return "";
        }
        return gson.toJson(src, typeOfSrc);
    }

}
