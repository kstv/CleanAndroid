package com.github.promeg.doubanmovie.model.movie.storio;

import com.github.promeg.doubanmovie.model.movie.Movie;
import com.pushtorefresh.storio.sqlite.operations.delete.DefaultDeleteResolver;
import com.pushtorefresh.storio.sqlite.queries.DeleteQuery;

import android.support.annotation.NonNull;

/**
 * Generated resolver for Delete Operation
 */
public class MovieStorIOSQLiteDeleteResolver extends DefaultDeleteResolver<Movie> {
    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    protected DeleteQuery mapToDeleteQuery(@NonNull Movie movie) {
        return DeleteQuery.builder()
            .table(MovieTableMeta.TABLE)
            .where("id = ?")
            .whereArgs(movie.id())
            .build();
    }
}
