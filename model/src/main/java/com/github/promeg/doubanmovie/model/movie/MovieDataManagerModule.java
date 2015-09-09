package com.github.promeg.doubanmovie.model.movie;

import com.github.promeg.doubanmovie.model.di.ApiModule;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;

/**
 * Created by guyacong on 15/9/5.
 */
@Module(includes = ApiModule.class)
public class MovieDataManagerModule {

    @Provides
    public MovieDataManager provideMovieDataManager(MovieApi movieApi,
            StorIOSQLite storIOSQLite, @Named("io") Scheduler scheduler) {
        return MovieDataManagerImpl.getInstance(movieApi, storIOSQLite, scheduler);
    }
}
