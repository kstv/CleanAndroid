package com.promeg.github.doubanmovie.common.di;

import dagger.internal.Factory;
import de.greenrobot.event.EventBus;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class AppModule_ProvideBusFactory implements Factory<EventBus> {
  private final AppModule module;

  public AppModule_ProvideBusFactory(AppModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public EventBus get() {  
    EventBus provided = module.provideBus();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<EventBus> create(AppModule module) {  
    return new AppModule_ProvideBusFactory(module);
  }
}

