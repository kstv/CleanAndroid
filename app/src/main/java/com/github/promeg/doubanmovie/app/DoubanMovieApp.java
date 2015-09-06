package com.github.promeg.doubanmovie.app;

import com.facebook.stetho.Stetho;
import com.github.promeg.doubanmovie.BuildConfig;
import com.github.promeg.doubanmovie.ui.main.MainPresenterImpl;
import com.github.promeg.doubanmovie.utils.AppTestUtils;
import com.github.promeg.xlog_android.lib.XLogConfig;
import com.promeg.github.doubanmovie.common.base.IApplication;
import com.promeg.github.doubanmovie.common.di.AppModule;
import com.promeg.github.doubanmovie.common.di.ApplicationComponent;
import com.promeg.github.doubanmovie.common.di.DaggerApplicationComponent;
import com.promegu.xlog.base.XLogMethod;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Created by guyacong on 2015/9/4.
 */
public class DoubanMovieApp extends Application implements IApplication {

    //singleton
    private volatile static DoubanMovieApp GLOBAL_CONTEXT = null;

    private ApplicationComponent mApplicationComponent;

    public static DoubanMovieApp getInstance() {
        return GLOBAL_CONTEXT;
    }

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        GLOBAL_CONTEXT = this;

        mApplicationComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();

            Stetho.initialize(
                    Stetho.newInitializerBuilder(this)
                            .enableDumpapp(
                                    Stetho.defaultDumperPluginsProvider(this))
                            .enableWebKitInspector(
                                    Stetho.defaultInspectorModulesProvider(this))
                            .build());

        AppTestUtils.setRxSchedulersForUnitTestsIfNeeded();

        LeakCanary.install(this);

        Timber.plant(new Timber.DebugTree());

        //setup xlog
        if (BuildConfig.XLOG_ENABLED) {
            List<XLogMethod> xLogMethods = new ArrayList<>();
            xLogMethods.add(new XLogMethod("com.github.promeg.doubanmovie.model.movie.MainPresenterImpl", null));

            long startTime = System.currentTimeMillis();
            XLogConfig.config(XLogConfig.newConfigBuilder(this)
                    .logMethods(xLogMethods)
                    .build());
            Log.d("XLOG", "xlog init cost:  " + (System.currentTimeMillis() - startTime));
        }
    }

    public RefWatcher getRefWatcher() {
        return refWatcher;
    }

    @Override
    public ApplicationComponent component() {
        return mApplicationComponent;
    }
}
