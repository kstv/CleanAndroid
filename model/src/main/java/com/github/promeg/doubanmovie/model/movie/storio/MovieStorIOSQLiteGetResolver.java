package com.github.promeg.doubanmovie.model.movie.storio;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.github.promeg.doubanmovie.model.movie.Movie;
import com.pushtorefresh.storio.sqlite.operations.get.DefaultGetResolver;

import android.database.Cursor;
import android.support.annotation.NonNull;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Generated resolver for Get Operation
 */
public class MovieStorIOSQLiteGetResolver extends DefaultGetResolver<Movie> {

    Gson mGson;

    public MovieStorIOSQLiteGetResolver(@NonNull Gson gson) {
        mGson = gson;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public Movie mapFromCursor(@NonNull Cursor cursor) {

        Type stringListType = new TypeToken<ArrayList<String>>() {
        }.getType();
        Type castsListType = new TypeToken<ArrayList<Movie.Casts>>() {
        }.getType();

        Movie.Rating rating = mGson.fromJson(cursor.getString(cursor.getColumnIndex("rating")),
                Movie.Rating.class);

        Movie.Images images = mGson.fromJson(cursor.getString(cursor.getColumnIndex("images")),
                Movie.Images.class);

        List<String> genres = mGson.fromJson(cursor.getString(cursor.getColumnIndex("genres")),
                stringListType);
        List<String> countries = mGson
                .fromJson(cursor.getString(cursor.getColumnIndex("countries")),
                        stringListType);
        List<String> aka = mGson
                .fromJson(cursor.getString(cursor.getColumnIndex("aka")), stringListType);
        List<Movie.Casts> casts = mGson
                .fromJson(cursor.getString(cursor.getColumnIndex("casts")), castsListType);
        List<Movie.Casts> directors = mGson
                .fromJson(cursor.getString(cursor.getColumnIndex("directors")), castsListType);

        Movie movie = Movie.builder()
                .id(cursor.getLong(cursor.getColumnIndex("id")))
                .reviews_count(cursor.getInt(cursor.getColumnIndex("reviews_count")))
                .wish_count(cursor.getInt(cursor.getColumnIndex("wish_count")))
                .collect_count(cursor.getInt(cursor.getColumnIndex("collect_count")))
                .do_count(cursor.getInt(cursor.getColumnIndex("do_count")))
                .seasons_count(cursor.getInt(cursor.getColumnIndex("seasons_count")))
                .episodes_count(cursor.getInt(cursor.getColumnIndex("episodes_count")))
                .current_season(cursor.getInt(cursor.getColumnIndex("current_season")))
                .comments_count(cursor.getInt(cursor.getColumnIndex("comments_count")))
                .ratings_count(cursor.getInt(cursor.getColumnIndex("ratings_count")))
                .douban_site(cursor.getString(cursor.getColumnIndex("douban_site")))
                .year(cursor.getString(cursor.getColumnIndex("year")))
                .alt(cursor.getString(cursor.getColumnIndex("alt")))
                .mobile_url(cursor.getString(cursor.getColumnIndex("mobile_url")))
                .title(cursor.getString(cursor.getColumnIndex("title")))
                .schedule_url(cursor.getString(cursor.getColumnIndex("schedule_url")))
                .original_title(cursor.getString(cursor.getColumnIndex("original_title")))
                .summary(cursor.getString(cursor.getColumnIndex("summary")))
                .subtype(cursor.getString(cursor.getColumnIndex("subtype")))
                .rating(rating)
                .images(images)
                .genres(genres)
                .countries(countries)
                .aka(aka)
                .casts(casts)
                .directors(directors)
                .build();

        return movie;
    }
}
