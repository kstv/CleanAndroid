package com.github.promeg.doubanmovie.ui.main;

import com.github.promeg.doubanmovie.model.movie.MovieDataManager;
import com.github.promeg.doubanmovie.ui.main.mvp.MainPresenter;
import com.github.promeg.doubanmovie.ui.main.mvp.MainView;
import com.promeg.github.doubanmovie.common.base.BaseRxPresenter;
import com.promeg.github.doubanmovie.common.utils.rx.RxUtils;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenterImpl extends BaseRxPresenter<MainView> implements MainPresenter {

    EventBus mBus;

    MovieDataManager mMovieDataManager;

    @Inject
    public MainPresenterImpl(EventBus bus, MovieDataManager movieDataManager) {
        mBus = bus;
        mMovieDataManager = movieDataManager;
    }

    @NonNull
    @Override
    protected EventBus getBus() {
        return mBus;
    }

    @Override
    public void loadMovie(Long id) {
        addSubscribe(mMovieDataManager.movie(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movie -> {
                    if (movie != null && isViewAttached()) {
                        getView().showMovie(movie);
                    }
                }, RxUtils.OnErrorLog));
    }
}
