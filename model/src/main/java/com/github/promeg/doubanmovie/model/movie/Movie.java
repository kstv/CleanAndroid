package com.github.promeg.doubanmovie.model.movie;

import com.promeg.github.doubanmovie.common.utils.gson.AutoGson;

import android.os.Parcelable;

import java.util.List;

import auto.parcel.AutoParcel;

/**
 * Movie类，用于网络返回数据的反序列化，及序列化后存储到DB中
 *
 * 注意:
 * 1. Movie类为immutable，可通过toBuilder().....build()基于已有对象创建新对象;
 * 2. Movie类中的域应严格与服务器返回的数据一样，不能因为UI需求增加新域（使用Presentation Model模式）
 *
 * AutoParcel库：https://github.com/frankiesardo/auto-parcel
 * AntoValue资料： https://github.com/google/auto/tree/master/value
 * Presentation Model模式: http://martinfowler.com/eaaDev/PresentationModel.html
 * Presentation Model示例：http://hannesdorfmann.com/mosby/mvp/
 *
 * Created by guyacong on 2015/9/4.
 */
@AutoParcel
@AutoGson(autoValueClass = AutoParcel_Movie.class)
public abstract class Movie implements Parcelable {

    public abstract Rating rating();

    public abstract int reviews_count();

    public abstract int wish_count();

    public abstract int collect_count();

    public abstract String douban_site();

    public abstract String year();

    public abstract Images images();

    public abstract String alt();

    public abstract Long id();

    public abstract String mobile_url();

    public abstract String title();

    public abstract int do_count();

    public abstract int seasons_count();

    public abstract String schedule_url();

    public abstract int episodes_count();

    public abstract int current_season();

    public abstract String original_title();

    public abstract String summary();

    public abstract String subtype();

    public abstract int comments_count();

    public abstract int ratings_count();

    public abstract List<String> genres();

    public abstract List<String> countries();

    public abstract List<Casts> casts();

    public abstract List<Casts> directors();

    public abstract List<String> aka();

    public static Builder builder() {
        return new AutoParcel_Movie.Builder();
    }

    public abstract Builder toBuilder();

    @AutoParcel.Builder
    public abstract static class Builder {

        public abstract Builder rating(Rating rating);

        public abstract Builder reviews_count(int n);

        public abstract Builder wish_count(int n);

        public abstract Builder do_count(int n);

        public abstract Builder seasons_count(int n);

        public abstract Builder episodes_count(int n);

        public abstract Builder current_season(int n);

        public abstract Builder collect_count(int n);

        public abstract Builder douban_site(String site);

        public abstract Builder year(String year);

        public abstract Builder alt(String alt);

        public abstract Builder images(Images images);

        public abstract Builder id(Long id);

        public abstract Builder mobile_url(String mobile_url);

        public abstract Builder title(String title);

        public abstract Builder schedule_url(String schedule_url);

        public abstract Builder original_title(String original_title);

        public abstract Builder summary(String summary);

        public abstract Builder subtype(String subtype);

        public abstract Builder comments_count(int comments_count);

        public abstract Builder ratings_count(int ratings_count);

        public abstract Builder genres(List<String> genres);

        public abstract Builder countries(List<String> countries);

        public abstract Builder casts(List<Casts> casts);

        public abstract Builder directors(List<Casts> directors);

        public abstract Builder aka(List<String> aka);

        public abstract Movie build();
    }


    @AutoParcel
    @AutoGson(autoValueClass = AutoParcel_Movie_Rating.class)
    public abstract static class Rating implements Parcelable {

        public abstract int max();

        public abstract double average();

        public abstract String stars();

        public abstract int min();

        public static Rating of(int max, double average, String stars, int min) {
            return new AutoParcel_Movie_Rating(max, average, stars, min);
        }
    }

    @AutoParcel
    @AutoGson(autoValueClass = AutoParcel_Movie_Images.class)
    public abstract static class Images implements Parcelable {

        public abstract String small();

        public abstract String large();

        public abstract String medium();

        public static Images of(String small, String large, String medium) {
            return new AutoParcel_Movie_Images(small, large, medium);
        }
    }

    @AutoParcel
    @AutoGson(autoValueClass = AutoParcel_Movie_Casts.class)
    public abstract static class Casts implements Parcelable {

        public abstract Images avatars();

        public abstract String alt();

        public abstract String id();

        public abstract String name();

        public static Casts of(Images avtars, String alt, String id, String name) {
            return new AutoParcel_Movie_Casts(avtars, alt, id, name);
        }
    }
}
