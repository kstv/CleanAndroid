package com.github.promeg.doubanmovie.model.di;

import dagger.internal.Factory;
import javax.annotation.Generated;
import rx.Scheduler;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ApiModule_ProvideIoSchedulerFactory implements Factory<Scheduler> {
  private final ApiModule module;

  public ApiModule_ProvideIoSchedulerFactory(ApiModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public Scheduler get() {  
    Scheduler provided = module.provideIoScheduler();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Scheduler> create(ApiModule module) {  
    return new ApiModule_ProvideIoSchedulerFactory(module);
  }
}

