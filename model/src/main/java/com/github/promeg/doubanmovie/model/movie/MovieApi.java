package com.github.promeg.doubanmovie.model.movie;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by guyacong on 2015/9/4.
 */
public interface MovieApi {

    @GET("/v2/movie/subject/{id}")
    Observable<Movie> movie(@Path("id") Long id);
}
