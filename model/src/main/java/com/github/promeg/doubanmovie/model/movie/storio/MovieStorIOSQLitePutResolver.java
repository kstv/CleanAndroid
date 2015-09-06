package com.github.promeg.doubanmovie.model.movie.storio;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.github.promeg.doubanmovie.model.movie.Movie;
import com.github.promeg.doubanmovie.model.utils.DbUtils;
import com.pushtorefresh.storio.sqlite.operations.put.DefaultPutResolver;
import com.pushtorefresh.storio.sqlite.queries.InsertQuery;
import com.pushtorefresh.storio.sqlite.queries.UpdateQuery;

import android.content.ContentValues;
import android.support.annotation.NonNull;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Generated resolver for Put Operation
 */
public class MovieStorIOSQLitePutResolver extends DefaultPutResolver<Movie> {

    Gson mGson;

    public MovieStorIOSQLitePutResolver(@NonNull Gson gson) {
        mGson = gson;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    protected InsertQuery mapToInsertQuery(@NonNull Movie object) {
        return InsertQuery.builder()
                .table(MovieTableMeta.TABLE)
                .build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    protected UpdateQuery mapToUpdateQuery(@NonNull Movie object) {
        return UpdateQuery.builder()
                .table(MovieTableMeta.TABLE)
                .where("id = ?")
                .whereArgs(object.id())
                .build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public ContentValues mapToContentValues(@NonNull Movie movie) {
        ContentValues contentValues = new ContentValues(22);
        Type stringListType = new TypeToken<ArrayList<String>>() {
        }.getType();
        Type stringCastsType = new TypeToken<ArrayList<Movie.Casts>>() {
        }.getType();

        String rating = DbUtils.toStringSafely(mGson, movie.rating(), Movie.Rating.class);
        String images = DbUtils.toStringSafely(mGson, movie.images(), Movie.Images.class);
        String genres = DbUtils.toStringSafely(mGson, movie.genres(), stringListType);
        String countries = DbUtils.toStringSafely(mGson, movie.countries(), stringListType);
        String aka = DbUtils.toStringSafely(mGson, movie.aka(), stringListType);
        String casts = DbUtils.toStringSafely(mGson, movie.casts(), stringCastsType);
        String directors = DbUtils.toStringSafely(mGson, movie.directors(), stringCastsType);

        contentValues.put("reviews_count", movie.reviews_count());
        contentValues.put("wish_count", movie.wish_count());
        contentValues.put("collect_count", movie.collect_count());
        contentValues.put("douban_site", movie.douban_site());
        contentValues.put("year", movie.year());
        contentValues.put("alt", movie.alt());
        contentValues.put("id", movie.id());
        contentValues.put("mobile_url", movie.mobile_url());
        contentValues.put("title", movie.title());
        contentValues.put("do_count", movie.do_count());
        contentValues.put("seasons_count", movie.seasons_count());
        contentValues.put("schedule_url", movie.schedule_url());
        contentValues.put("episodes_count", movie.episodes_count());
        contentValues.put("current_season", movie.current_season());
        contentValues.put("original_title", movie.original_title());
        contentValues.put("summary", movie.summary());
        contentValues.put("subtype", movie.subtype());
        contentValues.put("comments_count", movie.comments_count());
        contentValues.put("ratings_count", movie.ratings_count());
        contentValues.put("rating", rating);
        contentValues.put("images", images);
        contentValues.put("genres", genres);
        contentValues.put("countries", countries);
        contentValues.put("aka", aka);
        contentValues.put("casts", casts);
        contentValues.put("directors", directors);

        return contentValues;
    }
}
