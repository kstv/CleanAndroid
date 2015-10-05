package com.promeg.github.doubanmovie.common.base;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BaseActivity_MembersInjector implements MembersInjector<BaseActivity> {
  private final MembersInjector<AppCompatActivity> supertypeInjector;
  private final Provider<Resources> mResourcesProvider;

  public BaseActivity_MembersInjector(MembersInjector<AppCompatActivity> supertypeInjector, Provider<Resources> mResourcesProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert mResourcesProvider != null;
    this.mResourcesProvider = mResourcesProvider;
  }

  @Override
  public void injectMembers(BaseActivity instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.mResources = mResourcesProvider.get();
  }

  public static MembersInjector<BaseActivity> create(MembersInjector<AppCompatActivity> supertypeInjector, Provider<Resources> mResourcesProvider) {  
      return new BaseActivity_MembersInjector(supertypeInjector, mResourcesProvider);
  }
}

