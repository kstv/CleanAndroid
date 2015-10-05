package com.github.promeg.doubanmovie.model.di;

import android.content.Context;
import com.google.gson.Gson;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ApiModule_ProvideStoreIOSQLiteFactory implements Factory<StorIOSQLite> {
  private final ApiModule module;
  private final Provider<Context> contextProvider;
  private final Provider<Gson> gsonProvider;

  public ApiModule_ProvideStoreIOSQLiteFactory(ApiModule module, Provider<Context> contextProvider, Provider<Gson> gsonProvider) {  
    assert module != null;
    this.module = module;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert gsonProvider != null;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public StorIOSQLite get() {  
    StorIOSQLite provided = module.provideStoreIOSQLite(contextProvider.get(), gsonProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<StorIOSQLite> create(ApiModule module, Provider<Context> contextProvider, Provider<Gson> gsonProvider) {  
    return new ApiModule_ProvideStoreIOSQLiteFactory(module, contextProvider, gsonProvider);
  }
}

