package wcci.acquisitionsinc;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Collection;

import org.junit.Test;

import wcci.acquisitionsinc.Category;
import wcci.acquisitionsinc.Review;
import wcci.acquisitionsinc.ReviewTag;

public class ReviewTagTest {

	@Test
	public void reviewTagClassShouldExist() {
		ReviewTag underTest = new ReviewTag();
	}
	
	@Test
	public void reviewTagConstructorShouldHaveNameAndReviews() {
		ReviewTag underTest = new ReviewTag("name", new Review());
	}
}
