package wcci.acquisitionsinc.controllerTests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import wcci.acquisitionsinc.Review;
import wcci.acquisitionsinc.ReviewRepository;

public class ReviewControllerTest {

	ReviewController underTest;
	Review review1;
	Review review2;
	
	@Before
	public void initalizer() {
		underTest = new ReviewController();
		review1 = new Review(1, "title", "image", "category", "content");
		review2 = new Review(2, "title2", "image2", "category2", "content2");
	}
	
	@Test
	public void shouldBeAbleToGetReviews() {
		Collection<Review> reviews = underTest.getReviews();
		assertThat(reviews, containsInAnyOrder(review1, review2));
	}
	
	@Test
	public void shouldBeAbleToGetOneReview() {
		Review review = underTest.getReview(1);
		assertThat(review, is(review1));
	}
}
