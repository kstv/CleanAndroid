package com.github.promeg.doubanmovie.model.utils;

import com.github.promeg.doubanmovie.model.movie.storio.MovieTableMeta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by guyacong on 15/9/5.
 */
public class ProducationSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "douban_movie.db";

    public ProducationSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static String getCreateMovieTable() {
        return "CREATE TABLE " + MovieTableMeta.TABLE + "("
                + MovieTableMeta.COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY, "
                + MovieTableMeta.COLUMN_RATING + " TEXT, "
                + MovieTableMeta.COLUMN_REVIEWS_COUNT + " INTEGER, "
                + MovieTableMeta.COLUMN_WISH_COUNT + " INTEGER, "
                + MovieTableMeta.COLUMN_COLLECT_COUNT + " INTEGER, "
                + MovieTableMeta.COLUMN_DOUBAN_SITE + " TEXT, "
                + MovieTableMeta.COLUMN_YEAR + " TEXT, "
                + MovieTableMeta.COLUMN_IMAGES + " TEXT, "
                + MovieTableMeta.COLUMN_ALT+ " TEXT, "
                + MovieTableMeta.COLUMN_MOBILE_URL + " TEXT, "
                + MovieTableMeta.COLUMN_TITLE + " TEXT, "
                + MovieTableMeta.COLUMN_DO_COUNT + " INTEGER, "
                + MovieTableMeta.COLUMN_SEASONS_COUNT + " INTEGER, "
                + MovieTableMeta.COLUMN_SCHEDULE_URL + " TEXT, "
                + MovieTableMeta.COLUMN_EPISODES_COUNT + " INTEGER, "
                + MovieTableMeta.COLUMN_CURRENT_SEASON + " INTEGER, "
                + MovieTableMeta.COLUMN_ORIGINAL_TITLE + " TEXT, "
                + MovieTableMeta.COLUMN_SUMMARY + " TEXT, "
                + MovieTableMeta.COLUMN_SUBTYPE + " TEXT, "
                + MovieTableMeta.COLUMN_COMMENTS_COUNT + " INTEGER, "
                + MovieTableMeta.COLUMN_RATINGS_COUNT + " INTEGER, "
                + MovieTableMeta.COLUMN_GENRES + " TEXT, "
                + MovieTableMeta.COLUMN_CASTS + " TEXT, "
                + MovieTableMeta.COLUMN_DIRECTORS + " TEXT, "
                + MovieTableMeta.COLUMN_AKA + " TEXT, "
                + MovieTableMeta.COLUMN_COUNTRIES + " TEXT"
                + ");";
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getCreateMovieTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
