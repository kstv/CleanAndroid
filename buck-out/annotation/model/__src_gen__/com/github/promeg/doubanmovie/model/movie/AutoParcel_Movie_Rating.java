
package com.github.promeg.doubanmovie.model.movie;

final class AutoParcel_Movie_Rating extends Movie.Rating {

  private final int max;
  private final double average;
  private final String stars;
  private final int min;

  AutoParcel_Movie_Rating(
      int max,
      double average,
      String stars,
      int min) {
    this.max = max;
    this.average = average;
    if (stars == null) {
      throw new NullPointerException("Null stars");
    }
    this.stars = stars;
    this.min = min;
  }

  @Override
  public int max() {
    return max;
  }

  @Override
  public double average() {
    return average;
  }

  @Override
  public String stars() {
    return stars;
  }

  @Override
  public int min() {
    return min;
  }

  @Override
  public String toString() {
    return "Rating{"
        + "max=" + max + ", "
        + "average=" + average + ", "
        + "stars=" + stars + ", "
        + "min=" + min
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Movie.Rating) {
      Movie.Rating that = (Movie.Rating) o;
      return (this.max == that.max())
           && (Double.doubleToLongBits(this.average) == Double.doubleToLongBits(that.average()))
           && (this.stars.equals(that.stars()))
           && (this.min == that.min());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= max;
    h *= 1000003;
    h ^= (Double.doubleToLongBits(average) >>> 32) ^ Double.doubleToLongBits(average);
    h *= 1000003;
    h ^= stars.hashCode();
    h *= 1000003;
    h ^= min;
    return h;
  }

  public static final android.os.Parcelable.Creator<AutoParcel_Movie_Rating> CREATOR = new android.os.Parcelable.Creator<AutoParcel_Movie_Rating>() {
    @Override
    public AutoParcel_Movie_Rating createFromParcel(android.os.Parcel in) {
      return new AutoParcel_Movie_Rating(in);
    }
    @Override
    public AutoParcel_Movie_Rating[] newArray(int size) {
      return new AutoParcel_Movie_Rating[size];
    }
  };

  private final static java.lang.ClassLoader CL = AutoParcel_Movie_Rating.class.getClassLoader();

  private AutoParcel_Movie_Rating(android.os.Parcel in) {
    this((Integer) in.readValue(CL), (Double) in.readValue(CL), (String) in.readValue(CL), (Integer) in.readValue(CL));
  }

  @Override
  public void writeToParcel(android.os.Parcel dest, int flags) {
          dest.writeValue(max);
          dest.writeValue(average);
          dest.writeValue(stars);
          dest.writeValue(min);
      }

  @Override
  public int describeContents() {
    return 0;
  }

}
