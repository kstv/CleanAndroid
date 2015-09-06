package com.github.promeg.doubanmovie.ui.main.di;

import com.github.promeg.doubanmovie.model.movie.MovieDataManager;
import com.github.promeg.doubanmovie.ui.main.MainPresenterImpl;
import com.github.promeg.doubanmovie.ui.main.mvp.MainPresenter;
import com.promeg.github.doubanmovie.common.di.PerActivity;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

@Module
public class MainModule {
    @PerActivity
    @Provides
    public MainPresenter provideMainPresenter(EventBus bus, MovieDataManager movieDataManager) {
        return new MainPresenterImpl(bus, movieDataManager);
    }
}
