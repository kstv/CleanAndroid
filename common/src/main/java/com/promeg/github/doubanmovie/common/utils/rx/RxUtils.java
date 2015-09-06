package com.promeg.github.doubanmovie.common.utils.rx;

import rx.functions.Action1;
import timber.log.Timber;

public class RxUtils {
    private RxUtils() {
        //no instance
    }

    public static Action1<Throwable> OnErrorLog = new Action1<Throwable>() {
        @Override
        public void call(Throwable throwable) {
            //ignore other errors, but log it
            Timber.e(throwable, "Rx OnErrorLog");
        }
    };
}
