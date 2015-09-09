package com.github.promeg.doubanmovie.ui.main.di;


import com.github.promeg.doubanmovie.model.movie.MovieDataManagerModule;
import com.github.promeg.doubanmovie.ui.main.MainActivity;
import com.github.promeg.doubanmovie.ui.main.MainActivityFragment;
import com.github.promeg.doubanmovie.ui.main.MainPresenterImpl;
import com.github.promeg.doubanmovie.ui.main.mvp.MainPresenter;
import com.promeg.github.doubanmovie.common.di.ActivityComponent;
import com.promeg.github.doubanmovie.common.di.ActivityModule;
import com.promeg.github.doubanmovie.common.di.ApplicationComponent;
import com.promeg.github.doubanmovie.common.di.PerActivity;

import dagger.Component;

@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                MainModule.class,
                ActivityModule.class,
                MovieDataManagerModule.class
        }
)
public interface MainComponent extends ActivityComponent {

    void inject(MainActivity activity);

    void inject(MainActivityFragment fragment);

    MainPresenter presenter();
}
