package com.promeg.github.doubanmovie.common.di;

import android.content.ContentResolver;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class AppModule_ProvideContentResolverFactory implements Factory<ContentResolver> {
  private final AppModule module;

  public AppModule_ProvideContentResolverFactory(AppModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public ContentResolver get() {  
    ContentResolver provided = module.provideContentResolver();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<ContentResolver> create(AppModule module) {  
    return new AppModule_ProvideContentResolverFactory(module);
  }
}

