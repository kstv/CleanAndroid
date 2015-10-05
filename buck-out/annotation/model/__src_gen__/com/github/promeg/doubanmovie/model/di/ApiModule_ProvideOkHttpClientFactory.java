package com.github.promeg.doubanmovie.model.di;

import com.squareup.okhttp.OkHttpClient;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ApiModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final ApiModule module;

  public ApiModule_ProvideOkHttpClientFactory(ApiModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public OkHttpClient get() {  
    OkHttpClient provided = module.provideOkHttpClient();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<OkHttpClient> create(ApiModule module) {  
    return new ApiModule_ProvideOkHttpClientFactory(module);
  }
}

