package com.github.promeg.doubanmovie.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.github.promeg.doubanmovie.R;
import com.github.promeg.doubanmovie.model.movie.Movie;
import com.github.promeg.doubanmovie.ui.main.di.MainComponent;
import com.github.promeg.doubanmovie.ui.main.mvp.MainPresenter;
import com.github.promeg.doubanmovie.ui.main.mvp.MainView;
import com.jakewharton.rxbinding.view.RxView;
import com.promeg.github.doubanmovie.common.Constants;
import com.promeg.github.doubanmovie.common.base.BaseFragment;
import com.promeg.github.doubanmovie.common.utils.rx.TimeWindowFilter;
import de.greenrobot.event.EventBus;
import javax.inject.Inject;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Timestamped;

public class MainActivityFragment extends BaseFragment<MainView, MainPresenter>
        implements MainView {

    MainComponent mMainComponent;

    @Inject
    EventBus mBus;

    Button mBtnLoadMovie;

    TextView mTvContent;

    public MainActivityFragment() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind(view);
        initView();
    }

    private void bind(View view) {
        mBtnLoadMovie = ButterKnife.findById(view, R.id.btn_load_movie);
        mTvContent = ButterKnife.findById(view, R.id.tv_content);
    }

    private void initView() {
        RxView.clicks(mBtnLoadMovie)
                .takeUntil(RxView.detaches(mBtnLoadMovie))
                .timestamp()
                .lift(new TimeWindowFilter<>(Constants.NET_REQUEST_TIME_WINDOW_MILLIS))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Timestamped<Object>>() {
                    @Override
                    public void call(Timestamped<Object> objectTimestamped) {
                        presenter.loadMovie(1764796L);
                    }
                });
    }

    @Override
    protected void injectDependencies() {
        mMainComponent = this.getComponent(MainComponent.class);
        mMainComponent.inject(this);
    }

    @Override
    public MainPresenter createPresenter() {
        return mMainComponent.presenter();
    }

    @NonNull
    @Override
    protected EventBus getBus() {
        return mBus;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_main;
    }

    @Override
    public void showMovie(Movie movie) {
        if (movie != null) {
            mTvContent.setText(movie.title());
        }
    }
}
