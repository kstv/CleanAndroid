package com.github.promeg.doubanmovie.model.di;

import com.github.promeg.doubanmovie.model.movie.MovieApi;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ApiModule_ProvideMovieApiFactory implements Factory<MovieApi> {
  private final ApiModule module;
  private final Provider<Gson> gsonProvider;
  private final Provider<OkHttpClient> clientProvider;

  public ApiModule_ProvideMovieApiFactory(ApiModule module, Provider<Gson> gsonProvider, Provider<OkHttpClient> clientProvider) {  
    assert module != null;
    this.module = module;
    assert gsonProvider != null;
    this.gsonProvider = gsonProvider;
    assert clientProvider != null;
    this.clientProvider = clientProvider;
  }

  @Override
  public MovieApi get() {  
    MovieApi provided = module.provideMovieApi(gsonProvider.get(), clientProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<MovieApi> create(ApiModule module, Provider<Gson> gsonProvider, Provider<OkHttpClient> clientProvider) {  
    return new ApiModule_ProvideMovieApiFactory(module, gsonProvider, clientProvider);
  }
}

