
package com.github.promeg.doubanmovie.model.movie;

final class AutoParcel_Movie_Casts extends Movie.Casts {

  private final Movie.Images avatars;
  private final String alt;
  private final String id;
  private final String name;

  AutoParcel_Movie_Casts(
      Movie.Images avatars,
      String alt,
      String id,
      String name) {
    if (avatars == null) {
      throw new NullPointerException("Null avatars");
    }
    this.avatars = avatars;
    if (alt == null) {
      throw new NullPointerException("Null alt");
    }
    this.alt = alt;
    if (id == null) {
      throw new NullPointerException("Null id");
    }
    this.id = id;
    if (name == null) {
      throw new NullPointerException("Null name");
    }
    this.name = name;
  }

  @Override
  public Movie.Images avatars() {
    return avatars;
  }

  @Override
  public String alt() {
    return alt;
  }

  @Override
  public String id() {
    return id;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public String toString() {
    return "Casts{"
        + "avatars=" + avatars + ", "
        + "alt=" + alt + ", "
        + "id=" + id + ", "
        + "name=" + name
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Movie.Casts) {
      Movie.Casts that = (Movie.Casts) o;
      return (this.avatars.equals(that.avatars()))
           && (this.alt.equals(that.alt()))
           && (this.id.equals(that.id()))
           && (this.name.equals(that.name()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= avatars.hashCode();
    h *= 1000003;
    h ^= alt.hashCode();
    h *= 1000003;
    h ^= id.hashCode();
    h *= 1000003;
    h ^= name.hashCode();
    return h;
  }

  public static final android.os.Parcelable.Creator<AutoParcel_Movie_Casts> CREATOR = new android.os.Parcelable.Creator<AutoParcel_Movie_Casts>() {
    @Override
    public AutoParcel_Movie_Casts createFromParcel(android.os.Parcel in) {
      return new AutoParcel_Movie_Casts(in);
    }
    @Override
    public AutoParcel_Movie_Casts[] newArray(int size) {
      return new AutoParcel_Movie_Casts[size];
    }
  };

  private final static java.lang.ClassLoader CL = AutoParcel_Movie_Casts.class.getClassLoader();

  private AutoParcel_Movie_Casts(android.os.Parcel in) {
    this((Movie.Images) in.readValue(CL), (String) in.readValue(CL), (String) in.readValue(CL), (String) in.readValue(CL));
  }

  @Override
  public void writeToParcel(android.os.Parcel dest, int flags) {
          dest.writeValue(avatars);
          dest.writeValue(alt);
          dest.writeValue(id);
          dest.writeValue(name);
      }

  @Override
  public int describeContents() {
    return 0;
  }

}
