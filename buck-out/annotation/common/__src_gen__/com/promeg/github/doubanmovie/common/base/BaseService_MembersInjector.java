package com.promeg.github.doubanmovie.common.base;

import android.app.Service;
import dagger.MembersInjector;
import de.greenrobot.event.EventBus;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BaseService_MembersInjector implements MembersInjector<BaseService> {
  private final MembersInjector<Service> supertypeInjector;
  private final Provider<EventBus> mBusProvider;

  public BaseService_MembersInjector(MembersInjector<Service> supertypeInjector, Provider<EventBus> mBusProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert mBusProvider != null;
    this.mBusProvider = mBusProvider;
  }

  @Override
  public void injectMembers(BaseService instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.mBus = mBusProvider.get();
  }

  public static MembersInjector<BaseService> create(MembersInjector<Service> supertypeInjector, Provider<EventBus> mBusProvider) {  
      return new BaseService_MembersInjector(supertypeInjector, mBusProvider);
  }
}

