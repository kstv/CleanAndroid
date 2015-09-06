package com.promeg.github.doubanmovie.common.di;

import com.google.gson.Gson;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

/**
 * A module for Android-specific dependencies which require a {@link Context} or
 * {@link Application} to create.
 */
@Module
public class AppModule {
    private final Application application;

    public AppModule(@NonNull Application application) {
        this.application = application;
    }

    /**
     * Expose the application to the graph.
     */
    @Provides
    Application provideApplication(){
        return this.application;
    }

    @Provides
    Context provideAppContext() {
        return application.getApplicationContext();
    }

    @Provides
    Resources provideResources() {
        return application.getResources();
    }

    @Provides
    ContentResolver provideContentResolver() {
        return application.getContentResolver();
    }

    @Provides
    EventBus provideBus(){
        return BusProvider.getBus();
    }

    @Provides
    Gson provideGson() {
        return GsonProvider.getInstance().getGson();
    }
}
