package com.promeg.github.doubanmovie.common.di;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class AppModule_ProvideAppContextFactory implements Factory<Context> {
  private final AppModule module;

  public AppModule_ProvideAppContextFactory(AppModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public Context get() {  
    Context provided = module.provideAppContext();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Context> create(AppModule module) {  
    return new AppModule_ProvideAppContextFactory(module);
  }
}

