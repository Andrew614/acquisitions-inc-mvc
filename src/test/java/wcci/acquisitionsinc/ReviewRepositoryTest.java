package wcci.acquisitionsinc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ReviewRepositoryTest {

	ReviewRepository repository = new ReviewRepository();
	@Before
	
	public void initalize() {
		ReviewRepository repository = new ReviewRepository();
	}
	
	@Test
	public void shouldBeCreateAReviewRepository() {
		ReviewRepository repository = new ReviewRepository();
	}
	
	@Test
}
