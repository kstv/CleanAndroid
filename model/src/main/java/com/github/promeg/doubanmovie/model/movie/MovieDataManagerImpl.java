package com.github.promeg.doubanmovie.model.movie;

import com.github.promeg.doubanmovie.model.movie.storio.MovieTableMeta;
import com.promeg.github.doubanmovie.common.utils.Utility;
import com.promeg.github.doubanmovie.common.utils.visibility.PackagePrivate;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit.http.Path;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Func1;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Movie数据管理类
 * 负责管理与Movie相关的缓存、网络请求等逻辑
 *
 * Created by guyacong on 2015/9/5.
 */
@PackagePrivate
class MovieDataManagerImpl implements MovieDataManager {

    private volatile static MovieDataManagerImpl INSTANCE = null;

    private MovieApi mApi;

    private StorIOSQLite mStorDb;

    private Scheduler mScheduler;

    private MovieDataManagerImpl(MovieApi api, StorIOSQLite storDb, Scheduler scheduler) {
        //no instance
        mApi = api;
        mStorDb = storDb;
        mScheduler = scheduler;
    }

    public static MovieDataManagerImpl getInstance(@NonNull MovieApi api,
            @NonNull StorIOSQLite storDb, @NonNull Scheduler scheduler) {
        if (INSTANCE == null) {
            synchronized (MovieDataManagerImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieDataManagerImpl(api, storDb, scheduler);
                }
            }
        }

        return INSTANCE;
    }


    /**
     * 根据id获取movie详情
     *
     * 首先从DB中读取并emits缓存数据（如无缓存则返回null），同时请求网络数据
     *
     * 网络数据返回后写入（更新）DB，并emits
     */
    @Override
    public Observable<Movie> movie(@Path("id") Long id) {
        checkNotNull(id);
        checkArgument(id > 0);

        Observable<Movie> getFromDb = mStorDb.get().listOfObjects(Movie.class).withQuery(
                MovieTableMeta.queryId(id)).prepare().createObservable()
                .subscribeOn(mScheduler)
                .flatMap(new Func1<List<Movie>, Observable<Movie>>() {
                    @Override
                    public Observable<Movie> call(List<Movie> movies) {
                        Movie movie = (movies != null && movies.size() > 0) ? movies.get(0) : null;
                        return Observable.just(movie);
                    }
                });

        Observable<Movie> getFromServer = mApi.movie(id)
                .subscribeOn(mScheduler)
                .delay(3, TimeUnit.SECONDS, mScheduler) // 加入3s延迟，方便查看缓存效果
                .flatMap(new Func1<Movie, Observable<Movie>>() {
                    @Override
                    public Observable<Movie> call(Movie movie) {
                        // store to db
                        mStorDb.put().object(movie).prepare().executeAsBlocking();
                        Movie newMovie = movie.toBuilder().title(movie.title() + " from server")
                                .build();
                        return Observable.just(newMovie);
                    }
                });

        /**
         * 不能使用concat操作符
         *
         * 原因是StorIO返回的Observable不会onComplete（允许Subscriber监听数据改变）
         *
         * 虽然使用merge操作符“理论上”可能导致getFromServer先于getFromDb传给Subscriber
         * 由于在getFromServer中将最新数据写入了数据库，因此Subscriber仍能监听到改变
         */
        return Observable.merge(getFromDb, getFromServer);
    }


    @VisibleForTesting
    void setApiForTest(MovieApi movieApi) {
        if (Utility.isUnderRoboletricTest()) {
            this.mApi = movieApi;
        }
    }

    @VisibleForTesting
    void setSchedulerForTest(Scheduler scheduler) {
        if (Utility.isUnderRoboletricTest()) {
            this.mScheduler = scheduler;
        }
    }
}
