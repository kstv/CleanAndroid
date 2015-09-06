package com.promeg.github.doubanmovie.common.base;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by guyacong on 2015/9/4.
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V>{

    private V mView;

    /**
     * Set or attach the view to this presenter
     */
    @Override
    public void attachView(V view) {
        mView = view;
    }

    /**
     * Will be called if the view has been destroyed. Typically this method will be invoked from
     * <code>Activity.detachView()</code> or <code>Fragment.onDestroyView()</code>
     */
    @Override
    public void detachView(boolean retainInstance) {
        mView = null;
    }

    protected boolean isViewAttached(){
        return mView != null;
    }

    protected V getView(){
        return mView;
    }

}
