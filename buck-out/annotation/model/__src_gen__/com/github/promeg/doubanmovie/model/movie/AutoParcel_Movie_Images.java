
package com.github.promeg.doubanmovie.model.movie;

final class AutoParcel_Movie_Images extends Movie.Images {

  private final String small;
  private final String large;
  private final String medium;

  AutoParcel_Movie_Images(
      String small,
      String large,
      String medium) {
    if (small == null) {
      throw new NullPointerException("Null small");
    }
    this.small = small;
    if (large == null) {
      throw new NullPointerException("Null large");
    }
    this.large = large;
    if (medium == null) {
      throw new NullPointerException("Null medium");
    }
    this.medium = medium;
  }

  @Override
  public String small() {
    return small;
  }

  @Override
  public String large() {
    return large;
  }

  @Override
  public String medium() {
    return medium;
  }

  @Override
  public String toString() {
    return "Images{"
        + "small=" + small + ", "
        + "large=" + large + ", "
        + "medium=" + medium
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Movie.Images) {
      Movie.Images that = (Movie.Images) o;
      return (this.small.equals(that.small()))
           && (this.large.equals(that.large()))
           && (this.medium.equals(that.medium()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= small.hashCode();
    h *= 1000003;
    h ^= large.hashCode();
    h *= 1000003;
    h ^= medium.hashCode();
    return h;
  }

  public static final android.os.Parcelable.Creator<AutoParcel_Movie_Images> CREATOR = new android.os.Parcelable.Creator<AutoParcel_Movie_Images>() {
    @Override
    public AutoParcel_Movie_Images createFromParcel(android.os.Parcel in) {
      return new AutoParcel_Movie_Images(in);
    }
    @Override
    public AutoParcel_Movie_Images[] newArray(int size) {
      return new AutoParcel_Movie_Images[size];
    }
  };

  private final static java.lang.ClassLoader CL = AutoParcel_Movie_Images.class.getClassLoader();

  private AutoParcel_Movie_Images(android.os.Parcel in) {
    this((String) in.readValue(CL), (String) in.readValue(CL), (String) in.readValue(CL));
  }

  @Override
  public void writeToParcel(android.os.Parcel dest, int flags) {
          dest.writeValue(small);
          dest.writeValue(large);
          dest.writeValue(medium);
      }

  @Override
  public int describeContents() {
    return 0;
  }

}
