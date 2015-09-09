package com.github.promeg.doubanmovie.model.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.github.promeg.doubanmovie.model.movie.Movie;
import com.github.promeg.doubanmovie.model.movie.storio.MovieStorIOSQLiteDeleteResolver;
import com.github.promeg.doubanmovie.model.movie.storio.MovieStorIOSQLiteGetResolver;
import com.github.promeg.doubanmovie.model.movie.storio.MovieStorIOSQLitePutResolver;
import com.promeg.github.doubanmovie.common.Constants;
import com.promeg.github.doubanmovie.common.utils.gson.AutoValueTypeAdapterFactory;
import com.pushtorefresh.storio.sqlite.Changes;
import com.pushtorefresh.storio.sqlite.SQLiteTypeMapping;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.operations.delete.PreparedDelete;
import com.pushtorefresh.storio.sqlite.operations.execute.PreparedExecuteSQL;
import com.pushtorefresh.storio.sqlite.operations.get.PreparedGet;
import com.pushtorefresh.storio.sqlite.operations.put.PreparedPut;
import com.pushtorefresh.storio.sqlite.queries.DeleteQuery;
import com.pushtorefresh.storio.sqlite.queries.InsertQuery;
import com.pushtorefresh.storio.sqlite.queries.Query;
import com.pushtorefresh.storio.sqlite.queries.RawQuery;
import com.pushtorefresh.storio.sqlite.queries.UpdateQuery;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import rx.Observable;

import static org.mockito.Mockito.mock;

/**
 * Created by guyacong on 2015/9/7.
 */
public class StorIOSQLiteForTest extends StorIOSQLite {
    static final Map<Class<?>, SQLiteTypeMapping<?>> typesMapping = new HashMap<>();
    static{
        Gson gson =  new GsonBuilder()
                .setDateFormat(Constants.DATE_FORMAT)
                .registerTypeAdapterFactory(new AutoValueTypeAdapterFactory())
                .setPrettyPrinting().create();

        typesMapping.put(Movie.class, SQLiteTypeMapping.<Movie>builder()
                .putResolver(
                        new MovieStorIOSQLitePutResolver(gson))
                .getResolver(
                        new MovieStorIOSQLiteGetResolver(gson))
                .deleteResolver(
                        new MovieStorIOSQLiteDeleteResolver())
                .build());
    }
    @NonNull
    private final Internal internal = new Internal() {



        @Nullable
        @Override
        public <T> SQLiteTypeMapping<T> typeMapping(@NonNull Class<T> type) {
            // no impl
            final SQLiteTypeMapping<T> directTypeMapping = (SQLiteTypeMapping<T>) typesMapping.get(type);

            if (directTypeMapping != null) {
                // fffast! O(1)
                return directTypeMapping;
            } else {
                // If no direct type mapping found — search for indirect type mapping

                // May be value already in cache.
                SQLiteTypeMapping<T> indirectTypeMapping = null;

                // Okay, we don't have direct type mapping.
                // And we don't have cache for indirect type mapping.
                // Let's find indirect type mapping and cache it!
                Class<?> parentType = type.getSuperclass();

                // Search algorithm:
                // Walk through all parent types of passed type.
                // If parent type has direct mapping -> we found indirect type mapping!
                // If current parent type == Object.class -> there is no indirect type mapping.
                // Complexity:
                // O(n) where n is number of parent types of passed type (pretty fast).

                // Stop search if root parent is Object.class
                while (parentType != Object.class) {
                    indirectTypeMapping = (SQLiteTypeMapping<T>) typesMapping.get(parentType);

                    if (indirectTypeMapping != null) {
                        // Store this typeMapping as known to make resolving O(1) for the next time
                        return indirectTypeMapping;
                    }

                    parentType = parentType.getSuperclass();
                }

                // No indirect type mapping found.
                return null;
            }
        }

        @Override
        public void executeSQL(@NonNull RawQuery rawQuery) {
            // no impl
        }

        @NonNull
        @Override
        public Cursor rawQuery(@NonNull RawQuery rawQuery) {
            return mock(Cursor.class);
        }

        @NonNull
        @Override
        public Cursor query(@NonNull Query query) {
            return mock(Cursor.class);
        }

        @Override
        public long insert(@NonNull InsertQuery insertQuery, @NonNull ContentValues contentValues) {
            return 0;
        }

        @Override
        public int update(@NonNull UpdateQuery updateQuery, @NonNull ContentValues contentValues) {
            return 0;
        }

        @Override
        public int delete(@NonNull DeleteQuery deleteQuery) {
            return 0;
        }

        @Override
        public void notifyAboutChanges(@NonNull Changes changes) {
            // no impl
        }

        @Override
        public void beginTransaction() {
            // no impl
        }

        @Override
        public void setTransactionSuccessful() {
            // no impl
        }

        @Override
        public void endTransaction() {
            // no impl
        }
    };

    @NonNull
    @Override
    public Observable<Changes> observeChangesInTables(@NonNull Set<String> tables) {
        return Observable.empty();
    }

    @NonNull
    @Override
    public PreparedExecuteSQL.Builder executeSQL() {
        return new PreparedExecuteSQL.Builder(this);
    }

    @NonNull
    @Override
    public PreparedGet.Builder get() {
        return new PreparedGet.Builder(this);
    }

    @NonNull
    @Override
    public PreparedPut.Builder put() {
        return new PreparedPut.Builder(this);
    }

    @NonNull
    @Override
    public PreparedDelete.Builder delete() {
        return new PreparedDelete.Builder(this);
    }

    @NonNull
    @Override
    public Internal internal() {
        return internal;
    }

    @Override
    public void close() throws IOException {
        // no impl
    }
}
