package wcci.acquisitionsinc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ReviewRepositoryTest {
	
	Review underTest = new Review(1, "title", "imageUrl", "category", "content");
	ReviewRepository repository = new ReviewRepository();
	@Before
	
	public void initalize() {
		ReviewRepository repository = new ReviewRepository();
		Review underTest = new Review(1, "title", "imageUrl", "category", "content");
	}
	
	@Test
	public void shouldBeAbleToAddReviewAndGet() {
		repository.addReview(underTest);
		Review retrivedReview = repository.getReview(1);
		assertThat(retrivedReview, is(underTest));
		
		
	}
}
