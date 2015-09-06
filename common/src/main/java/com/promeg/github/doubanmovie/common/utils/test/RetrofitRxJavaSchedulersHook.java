package com.promeg.github.doubanmovie.common.utils.test;

import rx.Scheduler;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

/**
 * Created by guyacong on 15/5/24.
 */
public class RetrofitRxJavaSchedulersHook extends RxJavaSchedulersHook {
    @Override
    public Scheduler getIOScheduler() {
        return Schedulers.immediate();
    }
}
