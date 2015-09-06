package com.promeg.github.doubanmovie.common.base;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import android.support.annotation.NonNull;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.EventBusException;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Base presenter with rx support.
 *
 * Created by guyacong on 2015/4/14.
 */
public abstract class BaseRxPresenter<V extends MvpView> extends MvpBasePresenter<V> {
    private CompositeSubscription mCompositeSubscription = null;

    protected abstract @NonNull EventBus getBus();

    protected void addSubscribe(Subscription subscription){
        if(mCompositeSubscription == null || mCompositeSubscription.isUnsubscribed()){
            // recreate mCompositeSubscription
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    protected void unSubscribeAll(){
        if(mCompositeSubscription != null && !mCompositeSubscription.isUnsubscribed()){
            mCompositeSubscription.unsubscribe();
        }
        mCompositeSubscription = null;
    }

    protected void unSubscribe(Subscription subscription) {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.remove(subscription);
        }
    }



    @Override
    public void attachView(V view) {
        super.attachView(view);
        if(getBus() != null && !getBus().isRegistered(this)){
            try {
                getBus().register(this);
            }catch (EventBusException e){
                //e.printStackTrace();
            }
        }
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (!retainInstance) {
            unSubscribeAll();
        }
        if(getBus() != null && getBus().isRegistered(this)) {
            getBus().unregister(this);
        }
    }
}
