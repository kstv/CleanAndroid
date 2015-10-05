package com.promeg.github.doubanmovie.common.di;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.google.gson.Gson;
import com.promeg.github.doubanmovie.common.base.BaseActivity;
import com.promeg.github.doubanmovie.common.base.BaseActivity_MembersInjector;
import com.promeg.github.doubanmovie.common.base.BaseService;
import com.promeg.github.doubanmovie.common.base.BaseService_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import de.greenrobot.event.EventBus;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Resources> provideResourcesProvider;
  private MembersInjector<BaseActivity> baseActivityMembersInjector;
  private Provider<EventBus> provideBusProvider;
  private MembersInjector<BaseService> baseServiceMembersInjector;
  private Provider<Application> provideApplicationProvider;
  private Provider<Gson> provideGsonProvider;
  private Provider<Context> provideAppContextProvider;

  private DaggerApplicationComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  private void initialize(final Builder builder) {  
    this.provideResourcesProvider = AppModule_ProvideResourcesFactory.create(builder.appModule);
    this.baseActivityMembersInjector = BaseActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), provideResourcesProvider);
    this.provideBusProvider = AppModule_ProvideBusFactory.create(builder.appModule);
    this.baseServiceMembersInjector = BaseService_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), provideBusProvider);
    this.provideApplicationProvider = AppModule_ProvideApplicationFactory.create(builder.appModule);
    this.provideGsonProvider = AppModule_ProvideGsonFactory.create(builder.appModule);
    this.provideAppContextProvider = AppModule_ProvideAppContextFactory.create(builder.appModule);
  }

  @Override
  public void inject(BaseActivity activity) {  
    baseActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(BaseService baseService) {  
    baseServiceMembersInjector.injectMembers(baseService);
  }

  @Override
  public Application application() {  
    return provideApplicationProvider.get();
  }

  @Override
  public Resources resources() {  
    return provideResourcesProvider.get();
  }

  @Override
  public EventBus bus() {  
    return provideBusProvider.get();
  }

  @Override
  public Gson gson() {  
    return provideGsonProvider.get();
  }

  @Override
  public Context context() {  
    return provideAppContextProvider.get();
  }

  public static final class Builder {
    private AppModule appModule;
  
    private Builder() {  
    }
  
    public ApplicationComponent build() {  
      if (appModule == null) {
        throw new IllegalStateException("appModule must be set");
      }
      return new DaggerApplicationComponent(this);
    }
  
    public Builder appModule(AppModule appModule) {  
      if (appModule == null) {
        throw new NullPointerException("appModule");
      }
      this.appModule = appModule;
      return this;
    }
  }
}

