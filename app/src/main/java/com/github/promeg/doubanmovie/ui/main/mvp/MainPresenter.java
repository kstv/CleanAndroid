package com.github.promeg.doubanmovie.ui.main.mvp;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;

import rx.Observable;

public interface MainPresenter extends MvpPresenter<MainView> {
    void loadMovie(Long id);
}
