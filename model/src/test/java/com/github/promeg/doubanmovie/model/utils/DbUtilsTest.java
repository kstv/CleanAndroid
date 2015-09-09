package com.github.promeg.doubanmovie.model.utils;

import com.google.gson.Gson;

import com.github.promeg.doubanmovie.model.TestApp;
import com.promeg.github.doubanmovie.common.BuildConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21, constants = BuildConfig.class, application = TestApp.class)
public class DbUtilsTest {

    @Test(expected = NullPointerException.class)
    public void nullGsonShouldThrow(){
        DbUtils.toStringSafely(null, "", String.class);
    }

    @Test(expected = NullPointerException.class)
    public void nullTypeShouldThrow(){
        DbUtils.toStringSafely(new Gson(), "", null);
    }

    @Test
    public void nullSrcShouldReturnEmpryString(){
        String result = DbUtils.toStringSafely(new Gson(), null, String.class);
        assertThat(result, is(""));
    }

}
