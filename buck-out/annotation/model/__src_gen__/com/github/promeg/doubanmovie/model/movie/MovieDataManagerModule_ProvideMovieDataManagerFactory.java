package com.github.promeg.doubanmovie.model.movie;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import rx.Scheduler;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MovieDataManagerModule_ProvideMovieDataManagerFactory implements Factory<MovieDataManager> {
  private final MovieDataManagerModule module;
  private final Provider<MovieApi> movieApiProvider;
  private final Provider<StorIOSQLite> storIOSQLiteProvider;
  private final Provider<Scheduler> schedulerProvider;

  public MovieDataManagerModule_ProvideMovieDataManagerFactory(MovieDataManagerModule module, Provider<MovieApi> movieApiProvider, Provider<StorIOSQLite> storIOSQLiteProvider, Provider<Scheduler> schedulerProvider) {  
    assert module != null;
    this.module = module;
    assert movieApiProvider != null;
    this.movieApiProvider = movieApiProvider;
    assert storIOSQLiteProvider != null;
    this.storIOSQLiteProvider = storIOSQLiteProvider;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
  }

  @Override
  public MovieDataManager get() {  
    MovieDataManager provided = module.provideMovieDataManager(movieApiProvider.get(), storIOSQLiteProvider.get(), schedulerProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<MovieDataManager> create(MovieDataManagerModule module, Provider<MovieApi> movieApiProvider, Provider<StorIOSQLite> storIOSQLiteProvider, Provider<Scheduler> schedulerProvider) {  
    return new MovieDataManagerModule_ProvideMovieDataManagerFactory(module, movieApiProvider, storIOSQLiteProvider, schedulerProvider);
  }
}

