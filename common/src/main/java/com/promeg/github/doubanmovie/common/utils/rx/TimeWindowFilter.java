package com.promeg.github.doubanmovie.common.utils.rx;


import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Timestamped;

/**
 * Created by guyacong on 2015/9/4.
 */
public class TimeWindowFilter<T>
        implements Observable.Operator<Timestamped<T>, Timestamped<T>> {

    private final long mTimeWindowInMillis;

    public TimeWindowFilter(long timeWindowInMillis) {
        mTimeWindowInMillis = timeWindowInMillis;
    }

    @Override
    public Subscriber<? super Timestamped<T>> call(final Subscriber<? super Timestamped<T>> child) {
        return new Subscriber<Timestamped<T>>() {
            private Timestamped<T> mPrevious = null;
            private boolean hasPrevious = false;

            @Override
            public void onCompleted() {
                child.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                child.onError(e);
            }

            @Override
            public void onNext(Timestamped<T> event) {
                Timestamped<T> previousEvent = mPrevious;
                if (hasPrevious) {
                    if (event.getTimestampMillis() - previousEvent.getTimestampMillis() < mTimeWindowInMillis) {
                        request(1);
                    } else {
                        mPrevious = event;
                        child.onNext(event);
                    }
                } else {
                    mPrevious = event;
                    hasPrevious = true;
                    child.onNext(event);
                }
            }
        };
    }
}

