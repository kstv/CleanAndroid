
package com.github.promeg.doubanmovie.model.movie;

import java.util.BitSet;
import java.util.List;

final class AutoParcel_Movie extends Movie {

  private final Movie.Rating rating;
  private final int reviews_count;
  private final int wish_count;
  private final int collect_count;
  private final String douban_site;
  private final String year;
  private final Movie.Images images;
  private final String alt;
  private final Long id;
  private final String mobile_url;
  private final String title;
  private final int do_count;
  private final int seasons_count;
  private final String schedule_url;
  private final int episodes_count;
  private final int current_season;
  private final String original_title;
  private final String summary;
  private final String subtype;
  private final int comments_count;
  private final int ratings_count;
  private final List<String> genres;
  private final List<String> countries;
  private final List<Movie.Casts> casts;
  private final List<Movie.Casts> directors;
  private final List<String> aka;

  private AutoParcel_Movie(
      Movie.Rating rating,
      int reviews_count,
      int wish_count,
      int collect_count,
      String douban_site,
      String year,
      Movie.Images images,
      String alt,
      Long id,
      String mobile_url,
      String title,
      int do_count,
      int seasons_count,
      String schedule_url,
      int episodes_count,
      int current_season,
      String original_title,
      String summary,
      String subtype,
      int comments_count,
      int ratings_count,
      List<String> genres,
      List<String> countries,
      List<Movie.Casts> casts,
      List<Movie.Casts> directors,
      List<String> aka) {
    this.rating = rating;
    this.reviews_count = reviews_count;
    this.wish_count = wish_count;
    this.collect_count = collect_count;
    this.douban_site = douban_site;
    this.year = year;
    this.images = images;
    this.alt = alt;
    if (id == null) {
      throw new NullPointerException("Null id");
    }
    this.id = id;
    this.mobile_url = mobile_url;
    if (title == null) {
      throw new NullPointerException("Null title");
    }
    this.title = title;
    this.do_count = do_count;
    this.seasons_count = seasons_count;
    this.schedule_url = schedule_url;
    this.episodes_count = episodes_count;
    this.current_season = current_season;
    this.original_title = original_title;
    this.summary = summary;
    this.subtype = subtype;
    this.comments_count = comments_count;
    this.ratings_count = ratings_count;
    this.genres = genres;
    this.countries = countries;
    this.casts = casts;
    this.directors = directors;
    this.aka = aka;
  }

  @android.support.annotation.Nullable
  @Override
  public Movie.Rating rating() {
    return rating;
  }

  @android.support.annotation.Nullable
  @Override
  public int reviews_count() {
    return reviews_count;
  }

  @android.support.annotation.Nullable
  @Override
  public int wish_count() {
    return wish_count;
  }

  @android.support.annotation.Nullable
  @Override
  public int collect_count() {
    return collect_count;
  }

  @android.support.annotation.Nullable
  @Override
  public String douban_site() {
    return douban_site;
  }

  @android.support.annotation.Nullable
  @Override
  public String year() {
    return year;
  }

  @android.support.annotation.Nullable
  @Override
  public Movie.Images images() {
    return images;
  }

  @android.support.annotation.Nullable
  @Override
  public String alt() {
    return alt;
  }

  @Override
  public Long id() {
    return id;
  }

  @android.support.annotation.Nullable
  @Override
  public String mobile_url() {
    return mobile_url;
  }

  @Override
  public String title() {
    return title;
  }

  @android.support.annotation.Nullable
  @Override
  public int do_count() {
    return do_count;
  }

  @android.support.annotation.Nullable
  @Override
  public int seasons_count() {
    return seasons_count;
  }

  @android.support.annotation.Nullable
  @Override
  public String schedule_url() {
    return schedule_url;
  }

  @android.support.annotation.Nullable
  @Override
  public int episodes_count() {
    return episodes_count;
  }

  @android.support.annotation.Nullable
  @Override
  public int current_season() {
    return current_season;
  }

  @android.support.annotation.Nullable
  @Override
  public String original_title() {
    return original_title;
  }

  @android.support.annotation.Nullable
  @Override
  public String summary() {
    return summary;
  }

  @android.support.annotation.Nullable
  @Override
  public String subtype() {
    return subtype;
  }

  @android.support.annotation.Nullable
  @Override
  public int comments_count() {
    return comments_count;
  }

  @android.support.annotation.Nullable
  @Override
  public int ratings_count() {
    return ratings_count;
  }

  @android.support.annotation.Nullable
  @Override
  public List<String> genres() {
    return genres;
  }

  @android.support.annotation.Nullable
  @Override
  public List<String> countries() {
    return countries;
  }

  @android.support.annotation.Nullable
  @Override
  public List<Movie.Casts> casts() {
    return casts;
  }

  @android.support.annotation.Nullable
  @Override
  public List<Movie.Casts> directors() {
    return directors;
  }

  @android.support.annotation.Nullable
  @Override
  public List<String> aka() {
    return aka;
  }

  @Override
  public String toString() {
    return "Movie{"
        + "rating=" + rating + ", "
        + "reviews_count=" + reviews_count + ", "
        + "wish_count=" + wish_count + ", "
        + "collect_count=" + collect_count + ", "
        + "douban_site=" + douban_site + ", "
        + "year=" + year + ", "
        + "images=" + images + ", "
        + "alt=" + alt + ", "
        + "id=" + id + ", "
        + "mobile_url=" + mobile_url + ", "
        + "title=" + title + ", "
        + "do_count=" + do_count + ", "
        + "seasons_count=" + seasons_count + ", "
        + "schedule_url=" + schedule_url + ", "
        + "episodes_count=" + episodes_count + ", "
        + "current_season=" + current_season + ", "
        + "original_title=" + original_title + ", "
        + "summary=" + summary + ", "
        + "subtype=" + subtype + ", "
        + "comments_count=" + comments_count + ", "
        + "ratings_count=" + ratings_count + ", "
        + "genres=" + genres + ", "
        + "countries=" + countries + ", "
        + "casts=" + casts + ", "
        + "directors=" + directors + ", "
        + "aka=" + aka
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Movie) {
      Movie that = (Movie) o;
      return ((this.rating == null) ? (that.rating() == null) : this.rating.equals(that.rating()))
           && (this.reviews_count == that.reviews_count())
           && (this.wish_count == that.wish_count())
           && (this.collect_count == that.collect_count())
           && ((this.douban_site == null) ? (that.douban_site() == null) : this.douban_site.equals(that.douban_site()))
           && ((this.year == null) ? (that.year() == null) : this.year.equals(that.year()))
           && ((this.images == null) ? (that.images() == null) : this.images.equals(that.images()))
           && ((this.alt == null) ? (that.alt() == null) : this.alt.equals(that.alt()))
           && (this.id.equals(that.id()))
           && ((this.mobile_url == null) ? (that.mobile_url() == null) : this.mobile_url.equals(that.mobile_url()))
           && (this.title.equals(that.title()))
           && (this.do_count == that.do_count())
           && (this.seasons_count == that.seasons_count())
           && ((this.schedule_url == null) ? (that.schedule_url() == null) : this.schedule_url.equals(that.schedule_url()))
           && (this.episodes_count == that.episodes_count())
           && (this.current_season == that.current_season())
           && ((this.original_title == null) ? (that.original_title() == null) : this.original_title.equals(that.original_title()))
           && ((this.summary == null) ? (that.summary() == null) : this.summary.equals(that.summary()))
           && ((this.subtype == null) ? (that.subtype() == null) : this.subtype.equals(that.subtype()))
           && (this.comments_count == that.comments_count())
           && (this.ratings_count == that.ratings_count())
           && ((this.genres == null) ? (that.genres() == null) : this.genres.equals(that.genres()))
           && ((this.countries == null) ? (that.countries() == null) : this.countries.equals(that.countries()))
           && ((this.casts == null) ? (that.casts() == null) : this.casts.equals(that.casts()))
           && ((this.directors == null) ? (that.directors() == null) : this.directors.equals(that.directors()))
           && ((this.aka == null) ? (that.aka() == null) : this.aka.equals(that.aka()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (rating == null) ? 0 : rating.hashCode();
    h *= 1000003;
    h ^= reviews_count;
    h *= 1000003;
    h ^= wish_count;
    h *= 1000003;
    h ^= collect_count;
    h *= 1000003;
    h ^= (douban_site == null) ? 0 : douban_site.hashCode();
    h *= 1000003;
    h ^= (year == null) ? 0 : year.hashCode();
    h *= 1000003;
    h ^= (images == null) ? 0 : images.hashCode();
    h *= 1000003;
    h ^= (alt == null) ? 0 : alt.hashCode();
    h *= 1000003;
    h ^= id.hashCode();
    h *= 1000003;
    h ^= (mobile_url == null) ? 0 : mobile_url.hashCode();
    h *= 1000003;
    h ^= title.hashCode();
    h *= 1000003;
    h ^= do_count;
    h *= 1000003;
    h ^= seasons_count;
    h *= 1000003;
    h ^= (schedule_url == null) ? 0 : schedule_url.hashCode();
    h *= 1000003;
    h ^= episodes_count;
    h *= 1000003;
    h ^= current_season;
    h *= 1000003;
    h ^= (original_title == null) ? 0 : original_title.hashCode();
    h *= 1000003;
    h ^= (summary == null) ? 0 : summary.hashCode();
    h *= 1000003;
    h ^= (subtype == null) ? 0 : subtype.hashCode();
    h *= 1000003;
    h ^= comments_count;
    h *= 1000003;
    h ^= ratings_count;
    h *= 1000003;
    h ^= (genres == null) ? 0 : genres.hashCode();
    h *= 1000003;
    h ^= (countries == null) ? 0 : countries.hashCode();
    h *= 1000003;
    h ^= (casts == null) ? 0 : casts.hashCode();
    h *= 1000003;
    h ^= (directors == null) ? 0 : directors.hashCode();
    h *= 1000003;
    h ^= (aka == null) ? 0 : aka.hashCode();
    return h;
  }

  public static final android.os.Parcelable.Creator<AutoParcel_Movie> CREATOR = new android.os.Parcelable.Creator<AutoParcel_Movie>() {
    @Override
    public AutoParcel_Movie createFromParcel(android.os.Parcel in) {
      return new AutoParcel_Movie(in);
    }
    @Override
    public AutoParcel_Movie[] newArray(int size) {
      return new AutoParcel_Movie[size];
    }
  };

  private final static java.lang.ClassLoader CL = AutoParcel_Movie.class.getClassLoader();

  private AutoParcel_Movie(android.os.Parcel in) {
    this((Movie.Rating) in.readValue(CL), (Integer) in.readValue(CL), (Integer) in.readValue(CL), (Integer) in.readValue(CL), (String) in.readValue(CL), (String) in.readValue(CL), (Movie.Images) in.readValue(CL), (String) in.readValue(CL), (Long) in.readValue(CL), (String) in.readValue(CL), (String) in.readValue(CL), (Integer) in.readValue(CL), (Integer) in.readValue(CL), (String) in.readValue(CL), (Integer) in.readValue(CL), (Integer) in.readValue(CL), (String) in.readValue(CL), (String) in.readValue(CL), (String) in.readValue(CL), (Integer) in.readValue(CL), (Integer) in.readValue(CL), (List<String>) in.readValue(CL), (List<String>) in.readValue(CL), (List<Movie.Casts>) in.readValue(CL), (List<Movie.Casts>) in.readValue(CL), (List<String>) in.readValue(CL));
  }

  @Override
  public void writeToParcel(android.os.Parcel dest, int flags) {
          dest.writeValue(rating);
          dest.writeValue(reviews_count);
          dest.writeValue(wish_count);
          dest.writeValue(collect_count);
          dest.writeValue(douban_site);
          dest.writeValue(year);
          dest.writeValue(images);
          dest.writeValue(alt);
          dest.writeValue(id);
          dest.writeValue(mobile_url);
          dest.writeValue(title);
          dest.writeValue(do_count);
          dest.writeValue(seasons_count);
          dest.writeValue(schedule_url);
          dest.writeValue(episodes_count);
          dest.writeValue(current_season);
          dest.writeValue(original_title);
          dest.writeValue(summary);
          dest.writeValue(subtype);
          dest.writeValue(comments_count);
          dest.writeValue(ratings_count);
          dest.writeValue(genres);
          dest.writeValue(countries);
          dest.writeValue(casts);
          dest.writeValue(directors);
          dest.writeValue(aka);
      }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public Movie.Builder toBuilder() {
    return new Builder(this);
  }

  static final class Builder extends Movie.Builder {
    private final BitSet set$ = new BitSet();
    private Movie.Rating rating;
    private int reviews_count;
    private int wish_count;
    private int collect_count;
    private String douban_site;
    private String year;
    private Movie.Images images;
    private String alt;
    private Long id;
    private String mobile_url;
    private String title;
    private int do_count;
    private int seasons_count;
    private String schedule_url;
    private int episodes_count;
    private int current_season;
    private String original_title;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<String> genres;
    private List<String> countries;
    private List<Movie.Casts> casts;
    private List<Movie.Casts> directors;
    private List<String> aka;
    Builder() {
    }
    Builder(Movie source) {
      rating(source.rating());
      reviews_count(source.reviews_count());
      wish_count(source.wish_count());
      collect_count(source.collect_count());
      douban_site(source.douban_site());
      year(source.year());
      images(source.images());
      alt(source.alt());
      id(source.id());
      mobile_url(source.mobile_url());
      title(source.title());
      do_count(source.do_count());
      seasons_count(source.seasons_count());
      schedule_url(source.schedule_url());
      episodes_count(source.episodes_count());
      current_season(source.current_season());
      original_title(source.original_title());
      summary(source.summary());
      subtype(source.subtype());
      comments_count(source.comments_count());
      ratings_count(source.ratings_count());
      genres(source.genres());
      countries(source.countries());
      casts(source.casts());
      directors(source.directors());
      aka(source.aka());
    }
    @Override
    public Movie.Builder rating(Movie.Rating rating) {
      this.rating = rating;
            return this;
    }
    @Override
    public Movie.Builder reviews_count(int reviews_count) {
      this.reviews_count = reviews_count;
            return this;
    }
    @Override
    public Movie.Builder wish_count(int wish_count) {
      this.wish_count = wish_count;
            return this;
    }
    @Override
    public Movie.Builder collect_count(int collect_count) {
      this.collect_count = collect_count;
            return this;
    }
    @Override
    public Movie.Builder douban_site(String douban_site) {
      this.douban_site = douban_site;
            return this;
    }
    @Override
    public Movie.Builder year(String year) {
      this.year = year;
            return this;
    }
    @Override
    public Movie.Builder images(Movie.Images images) {
      this.images = images;
            return this;
    }
    @Override
    public Movie.Builder alt(String alt) {
      this.alt = alt;
            return this;
    }
    @Override
    public Movie.Builder id(Long id) {
      this.id = id;
      set$.set(0);
            return this;
    }
    @Override
    public Movie.Builder mobile_url(String mobile_url) {
      this.mobile_url = mobile_url;
            return this;
    }
    @Override
    public Movie.Builder title(String title) {
      this.title = title;
      set$.set(1);
            return this;
    }
    @Override
    public Movie.Builder do_count(int do_count) {
      this.do_count = do_count;
            return this;
    }
    @Override
    public Movie.Builder seasons_count(int seasons_count) {
      this.seasons_count = seasons_count;
            return this;
    }
    @Override
    public Movie.Builder schedule_url(String schedule_url) {
      this.schedule_url = schedule_url;
            return this;
    }
    @Override
    public Movie.Builder episodes_count(int episodes_count) {
      this.episodes_count = episodes_count;
            return this;
    }
    @Override
    public Movie.Builder current_season(int current_season) {
      this.current_season = current_season;
            return this;
    }
    @Override
    public Movie.Builder original_title(String original_title) {
      this.original_title = original_title;
            return this;
    }
    @Override
    public Movie.Builder summary(String summary) {
      this.summary = summary;
            return this;
    }
    @Override
    public Movie.Builder subtype(String subtype) {
      this.subtype = subtype;
            return this;
    }
    @Override
    public Movie.Builder comments_count(int comments_count) {
      this.comments_count = comments_count;
            return this;
    }
    @Override
    public Movie.Builder ratings_count(int ratings_count) {
      this.ratings_count = ratings_count;
            return this;
    }
    @Override
    public Movie.Builder genres(List<String> genres) {
      this.genres = genres;
            return this;
    }
    @Override
    public Movie.Builder countries(List<String> countries) {
      this.countries = countries;
            return this;
    }
    @Override
    public Movie.Builder casts(List<Movie.Casts> casts) {
      this.casts = casts;
            return this;
    }
    @Override
    public Movie.Builder directors(List<Movie.Casts> directors) {
      this.directors = directors;
            return this;
    }
    @Override
    public Movie.Builder aka(List<String> aka) {
      this.aka = aka;
            return this;
    }
    @Override
    public Movie build() {
      if (set$.cardinality() < 2) {
        String[] propertyNames = {
                           "id", "title",
        };
        StringBuilder missing = new StringBuilder();
        for (int i = 0; i < 2; i++) {
          if (!set$.get(i)) {
            missing.append(' ').append(propertyNames[i]);
          }
        }
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      Movie result = new AutoParcel_Movie(
          this.rating,
          this.reviews_count,
          this.wish_count,
          this.collect_count,
          this.douban_site,
          this.year,
          this.images,
          this.alt,
          this.id,
          this.mobile_url,
          this.title,
          this.do_count,
          this.seasons_count,
          this.schedule_url,
          this.episodes_count,
          this.current_season,
          this.original_title,
          this.summary,
          this.subtype,
          this.comments_count,
          this.ratings_count,
          this.genres,
          this.countries,
          this.casts,
          this.directors,
          this.aka);
      return result;
    }
  }
}
