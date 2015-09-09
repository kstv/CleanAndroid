package com.github.promeg.doubanmovie.model.movie;

import com.promeg.github.doubanmovie.common.BuildConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * 根据AutoValue官方文档，未采用Builder模式的AutoValue class须使用测试保证构造参数正确赋给相应的域
 *
 * "Use of AutoValue has one serious negative consequence: certain formerly safe refactorings could
 * now break your code, and be caught only by your tests.
 *
 * If you are not using builders, you must ensure that parameters are passed to the auto-generated
 * constructor in the same order the corresponding accessor methods are defined in the file. Your
 * tests must be sufficient to catch any field ordering problem. "
 *
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21, constants = BuildConfig.class)
public class MovieTest {

    @Test
    public void testMovie_Rating() {
        int max = 1;
        double average = 2.0;
        String stars = "stars";
        int min = 0;
        Movie.Rating rating = Movie.Rating.of(max, average, stars, min);

        assertThat(rating.max(), is(max));
        assertThat(rating.average(), is(average));
        assertThat(rating.stars(), is(stars));
        assertThat(rating.min(), is(min));
    }

    @Test
    public void testMovie_Images() {
        String small = "small";
        String large = "large";
        String medium = "medium";

        Movie.Images images = Movie.Images.of(small, large, medium);

        assertThat(images.small(), is(small));
        assertThat(images.large(), is(large));
        assertThat(images.medium(), is(medium));
    }

    @Test
    public void testMovie_Casts() {
        Movie.Images images = Movie.Images.of("small", "large", "medium");
        String alt = "alt";
        String id = "id";
        String name = "name";

        Movie.Casts casts = Movie.Casts.of(images, alt, id, name);

        assertThat(casts.avatars(), is(images));
        assertThat(casts.alt(), is(alt));
        assertThat(casts.id(), is(id));
        assertThat(casts.name(), is(name));
    }
}
