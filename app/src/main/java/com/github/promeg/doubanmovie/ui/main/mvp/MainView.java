package com.github.promeg.doubanmovie.ui.main.mvp;

import com.github.promeg.doubanmovie.model.movie.Movie;
import com.hannesdorfmann.mosby.mvp.MvpView;

import android.support.annotation.NonNull;

public interface MainView extends MvpView {
    void showMovie(@NonNull Movie movie);
}
