package com.github.promeg.doubanmovie.app;

import com.facebook.buck.android.support.exopackage.DefaultApplicationLike;
import com.facebook.stetho.Stetho;
import com.github.promeg.xlog_android.lib.XLogConfig;
import com.promeg.github.doubanmovie.common.base.IApplication;
import com.promeg.github.doubanmovie.common.di.ApplicationComponent;
import com.promeg.github.doubanmovie.common.utils.test.TestUtils;
import com.promegu.xlog.base.XLogMethod;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

//import com.squareup.leakcanary.LeakCanary;
//import com.squareup.leakcanary.RefWatcher;

/**
 * Created by guyacong on 2015/9/4.
 */
public class DoubanMovieApp extends DefaultApplicationLike implements IApplication {

    //singleton
    private volatile static Context GLOBAL_CONTEXT = null;

    public static Context getInstance() {
        return GLOBAL_CONTEXT;
    }

    //private RefWatcher refWatcher;

    private final Application appContext;

    public DoubanMovieApp(Application appContext) {
        this.appContext = appContext;
        GLOBAL_CONTEXT = appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initialize(
                    Stetho.newInitializerBuilder(appContext)
                            .enableDumpapp(
                                    Stetho.defaultDumperPluginsProvider(appContext))
                            .enableWebKitInspector(
                                    Stetho.defaultInspectorModulesProvider(appContext))
                            .build());

        TestUtils.setRxSchedulersForUnitTestsIfNeeded();

        //LeakCanary.install(this);

        Timber.plant(new Timber.DebugTree());

        //setup xlog
        if (false) {
            List<XLogMethod> xLogMethods = new ArrayList<>();
            xLogMethods.add(new XLogMethod("com.github.promeg.doubanmovie.model.movie.MainPresenterImpl", null));

            long startTime = System.currentTimeMillis();
            XLogConfig.config(XLogConfig.newConfigBuilder(appContext)
                    .logMethods(xLogMethods)
                    .build());
            Log.d("XLOG", "xlog init cost:  " + (System.currentTimeMillis() - startTime));
        }
    }

    /*public RefWatcher getRefWatcher() {
        return refWatcher;
    }*/

    @Override
    public ApplicationComponent component() {
        return ((IApplication)appContext).component();
    }
}
