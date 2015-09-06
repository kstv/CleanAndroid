package com.github.promeg.doubanmovie.model.movie.storio;

import com.pushtorefresh.storio.sqlite.queries.Query;

import android.support.annotation.NonNull;

/**
 * Created by guyacong on 15/9/5.
 */
public class MovieTableMeta {

    @NonNull
    public static final String TABLE = "movies";

    @NonNull
    public static final String COLUMN_RATING = "rating";

    @NonNull
    public static final String COLUMN_REVIEWS_COUNT = "reviews_count";

    @NonNull
    public static final String COLUMN_WISH_COUNT = "wish_count";

    @NonNull
    public static final String COLUMN_COLLECT_COUNT = "collect_count";

    @NonNull
    public static final String COLUMN_DOUBAN_SITE = "douban_site";

    @NonNull
    public static final String COLUMN_YEAR = "year";

    @NonNull
    public static final String COLUMN_IMAGES = "images";

    @NonNull
    public static final String COLUMN_ALT = "alt";

    @NonNull
    public static final String COLUMN_ID = "id";

    @NonNull
    public static final String COLUMN_MOBILE_URL = "mobile_url";

    @NonNull
    public static final String COLUMN_TITLE = "title";

    @NonNull
    public static final String COLUMN_DO_COUNT = "do_count";

    @NonNull
    public static final String COLUMN_SEASONS_COUNT = "seasons_count";

    @NonNull
    public static final String COLUMN_SCHEDULE_URL = "schedule_url";

    @NonNull
    public static final String COLUMN_EPISODES_COUNT = "episodes_count";

    @NonNull
    public static final String COLUMN_CURRENT_SEASON = "current_season";

    @NonNull
    public static final String COLUMN_ORIGINAL_TITLE = "original_title";

    @NonNull
    public static final String COLUMN_SUMMARY = "summary";

    @NonNull
    public static final String COLUMN_SUBTYPE = "subtype";

    @NonNull
    public static final String COLUMN_COMMENTS_COUNT = "comments_count";

    @NonNull
    public static final String COLUMN_RATINGS_COUNT = "ratings_count";

    @NonNull
    public static final String COLUMN_GENRES = "genres";

    @NonNull
    public static final String COLUMN_COUNTRIES = "countries";

    @NonNull
    public static final String COLUMN_CASTS = "casts";

    @NonNull
    public static final String COLUMN_DIRECTORS = "directors";

    @NonNull
    public static final String COLUMN_AKA = "aka";


    // Yep, with StorIO you can safely store queries as objects and reuse them, they are immutable
    @NonNull
    public static final Query QUERY_ALL = Query.builder()
            .table(TABLE)
            .build();

    public static @NonNull Query queryId(@NonNull Long id){
        return Query.builder()
                .table(MovieTableMeta.TABLE)
                .where("id = ?")
                .whereArgs(id)
                .build();
    }

    // This is just class with Meta Data, we don't need instances
    private MovieTableMeta() {
        throw new IllegalStateException("No instances please");
    }
}
