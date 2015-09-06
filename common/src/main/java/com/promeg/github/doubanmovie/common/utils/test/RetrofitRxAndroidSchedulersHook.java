package com.promeg.github.doubanmovie.common.utils.test;

import rx.Scheduler;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.schedulers.Schedulers;

/**
 * Created by guyacong on 15/5/24.
 */
public class RetrofitRxAndroidSchedulersHook extends RxAndroidSchedulersHook {
    @Override
    public Scheduler getMainThreadScheduler() {
        return Schedulers.immediate();
    }
}
