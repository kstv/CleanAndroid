package com.promeg.github.doubanmovie.common.utils.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.promeg.github.doubanmovie.common.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import auto.parcel.AutoParcel;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21, constants = BuildConfig.class)
public class AutoValueTypeAdapterFactoryTest {

    private Gson mGson;

    @AutoParcel
    @AutoGson(autoValueClass = AutoParcel_AutoValueTypeAdapterFactoryTest_Some.class)
    public abstract static class Some {

        public static Some of(String firstName, String lastName, int age) {
            return new AutoParcel_AutoValueTypeAdapterFactoryTest_Some(firstName, lastName, age);
        }

        public abstract String firstName();

        public abstract String lastName();

        public abstract int age();
    }

    @Before
    public void setUp() throws Exception {
        mGson = new GsonBuilder()
                .registerTypeAdapterFactory(new AutoValueTypeAdapterFactory())
                .create();
    }

    @Test
    public void testParsing() throws Exception {
        final Some inSome = Some.of("John", "Doe", 100);
        final String json = mGson.toJson(inSome);
        final Some outSome = mGson.fromJson(json, Some.class);

        assertThat(outSome).isEqualTo(inSome);
    }

}
