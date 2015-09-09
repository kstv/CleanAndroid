package com.github.promeg.doubanmovie.model;

import com.promeg.github.doubanmovie.common.utils.test.TestUtils;

import android.app.Application;

public class TestApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            TestUtils.setRxSchedulersForUnitTestsIfNeeded();
        } catch (Throwable t){
            // ignore
        }
    }
}
