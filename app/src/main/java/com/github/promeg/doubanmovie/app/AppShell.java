package com.github.promeg.doubanmovie.app;

import com.facebook.buck.android.support.exopackage.ExopackageApplication;
import com.promeg.github.doubanmovie.common.base.IApplication;
import com.promeg.github.doubanmovie.common.di.AppModule;
import com.promeg.github.doubanmovie.common.di.ApplicationComponent;
import com.promeg.github.doubanmovie.common.di.DaggerApplicationComponent;

/**
 * Created by guyacong on 15/10/2.
 */
public class AppShell extends ExopackageApplication implements IApplication {

    private ApplicationComponent mApplicationComponent;

    public AppShell() {
        super(com.github.promeg.doubanmovie.BuildConfig.EXOPACKAGE_FLAGS != 0);
    }

    @Override
    public ApplicationComponent component() {
        if (mApplicationComponent == null) {
            synchronized (this) {
                if (mApplicationComponent == null) {
                    mApplicationComponent = DaggerApplicationComponent.builder()
                            .appModule(new AppModule(this))
                            .build();
                }
            }
        }
        return mApplicationComponent;
    }
}
