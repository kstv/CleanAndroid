package com.github.promeg.doubanmovie.model.movie;

import com.github.promeg.doubanmovie.model.TestApp;
import com.github.promeg.doubanmovie.model.utils.StorIOSQLiteForTest;
import com.promeg.github.doubanmovie.common.BuildConfig;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.observers.TestSubscriber;
import rx.schedulers.TestScheduler;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21, constants = BuildConfig.class, application = TestApp.class)
public class MovieDataManagerImplTest {

    MovieDataManagerImpl mMovieDataManager;

    MovieApi mMovieApi;

    StorIOSQLite mStorIOSQLite;

    TestScheduler mScheduler;

    @Before
    public void setUp() {
        mMovieApi = mock(MovieApi.class);
        mStorIOSQLite = new StorIOSQLiteForTest();
        mScheduler = new TestScheduler();

        mMovieDataManager = MovieDataManagerImpl.getInstance(mMovieApi, mStorIOSQLite, mScheduler);

        mMovieDataManager.setApiForTest(mMovieApi);
        mMovieDataManager.setSchedulerForTest(mScheduler);
    }

    @Test(expected = NullPointerException.class)
    public void nullIdShouldThrow() {
        mMovieDataManager.movie(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeIdShouldThrow() {
        mMovieDataManager.movie(-1L);
    }

    /**
     * 四个测试点：
     *
     * expected result 1. 确认发出了正确的网络请求：MovieApi.movie();
     * expected result 2. 确认1s后返回了来自DB的数据；
     * expected result 3. 确认3s后返回了来自server的数据；
     * expected result 4. 过程中未产生错误；
     */
    @Test
    public void normalIdShouldReadFromDBThenServer() {

        when(mMovieApi.movie(anyLong())).thenReturn(Observable.just(provideMovie()));

        Observable<Movie> result = mMovieDataManager.movie(1L);

        verify(mMovieApi, times(1)).movie(anyLong()); // expected result 1

        TestSubscriber testSubscriber = new TestSubscriber();
        result.subscribe(testSubscriber);

        mScheduler.advanceTimeTo(1, TimeUnit.SECONDS);

        testSubscriber.assertValueCount(1); // expected result 2

        mScheduler.advanceTimeTo(3, TimeUnit.SECONDS);

        testSubscriber.assertValueCount(2); // expected result 3

        testSubscriber.assertNoErrors(); // expected result 4
    }

    private Movie provideMovie() {
        return Movie.builder()
                .id(1L)
                .title("title")
                .build();
    }

}
