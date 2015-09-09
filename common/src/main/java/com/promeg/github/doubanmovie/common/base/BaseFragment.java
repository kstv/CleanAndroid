package com.promeg.github.doubanmovie.common.base;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.promeg.github.doubanmovie.common.di.HasComponent;
import com.promeg.github.doubanmovie.common.utils.Utility;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.EventBusException;

/**
 * Base {@link android.app.Fragment} class for every fragment in this application.
 */
public abstract class BaseFragment<V extends MvpView, P extends MvpPresenter<V>> extends MvpFragment<V, P> {

    protected abstract @NonNull EventBus getBus();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(getBus().isRegistered(this)) {
            getBus().unregister(this);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /** injectDependencies() is called in super.onViewCreated()**/
        if(!getBus().isRegistered(this)) {
            try {
                getBus().register(this);
            }catch (EventBusException e){
                //e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

    /**
     * should only used in unit tests!
     *
     * @param presenter
     */
    @VisibleForTesting
    public void setPresenterForUnitTest(P presenter){
        if(!Utility.isUnderRoboletricTest()){
            throw new IllegalAccessError("setPresenterForUnitTest() should only used in unit tests!");
        }
        this.presenter = presenter;
        this.presenter.attachView(this.getMvpView());
    }
}
