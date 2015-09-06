package com.promeg.github.doubanmovie.common.di;

import com.google.gson.Gson;

import com.promeg.github.doubanmovie.common.base.BaseActivity;
import com.promeg.github.doubanmovie.common.base.BaseService;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Component;
import de.greenrobot.event.EventBus;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = AppModule.class)
public interface ApplicationComponent {

    // Field injections of any dependencies of the DemoApplication
    void inject(BaseActivity activity);

    void inject(BaseService baseService);

    // Exported for child-components.
    Application application();

    Resources resources();

    EventBus bus();

    Gson gson();

    Context context();
}
