package com.github.promeg.doubanmovie.model.di;


import com.google.gson.Gson;

import com.github.promeg.doubanmovie.model.movie.Movie;
import com.github.promeg.doubanmovie.model.movie.storio.MovieStorIOSQLiteDeleteResolver;
import com.github.promeg.doubanmovie.model.movie.storio.MovieStorIOSQLiteGetResolver;
import com.github.promeg.doubanmovie.model.movie.storio.MovieStorIOSQLitePutResolver;
import com.github.promeg.doubanmovie.model.utils.ProducationSQLiteOpenHelper;
import com.promeg.github.doubanmovie.common.utils.visibility.PackagePrivate;
import com.pushtorefresh.storio.sqlite.SQLiteTypeMapping;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite;

import android.content.Context;

/**
 * Created by guyacong on 2015/9/4.
 */
@PackagePrivate
class StorIOProvider {

    private static volatile StorIOSQLite INSTANCE;

    static StorIOSQLite getStorIO(final Context context, Gson gson) {
        if (INSTANCE == null) {
            synchronized (StorIOProvider.class) {
                if (INSTANCE == null) {
                    INSTANCE = DefaultStorIOSQLite.builder()
                            .sqliteOpenHelper(new ProducationSQLiteOpenHelper(context))
                            .addTypeMapping(Movie.class, SQLiteTypeMapping.<Movie>builder()
                                    .putResolver(
                                            new MovieStorIOSQLitePutResolver(gson))
                                    .getResolver(
                                            new MovieStorIOSQLiteGetResolver(gson))
                                    .deleteResolver(
                                            new MovieStorIOSQLiteDeleteResolver())
                                    .build())
                            .build();
                }
            }
        }

        return INSTANCE;
    }


    private StorIOProvider() {
        // No instances.
    }
}
