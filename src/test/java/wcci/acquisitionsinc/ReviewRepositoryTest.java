package wcci.acquisitionsinc;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import java.util.Collection;

import org.junit.Before;

public class ReviewRepositoryTest {

	Review review1;
	Review review2;
	Review review3;
	Review review4;
	Review review5;
	ReviewRepository underTest;

	@Before
	public void initalize() {
		review1 = new Review(1, "title", "imageUrl", "category", "content");
		review2 = new Review(2, "title2", "imageUrl2", "category2", "content2");
		review3 = new Review(3, "title3", "imageUrl3", "category3", "content3");
		review4 = new Review(4, "title4", "imageUrl4", "category4", "content4");
		underTest = new ReviewRepository();
	}

	@Test
	public void shouldBeAbleToAddReviewAndGet() {
		underTest.addReview(review1);
		Review retrivedReview = underTest.getReview(1);
		assertThat(retrivedReview, is(review1));
	}

	@Test
	public void shouldBeAbleToGetAllReviews() {
		underTest.addReview(review3);
		underTest.addReview(review4);
		underTest.addReview(review1);
		underTest.addReview(review2);
		Collection<Review> allReviews = underTest.getAllReviews();
		assertThat(allReviews, containsInAnyOrder(review1, review2, review3, review4));
	}

	@Test
	public void constructorShouldPopulateReviewsWithTwoReviews() {
		Collection<Review> allReviews = underTest.getAllReviews();
		Review default1 = new Review(1, "title", "image", "category", "content");
		Review default2 = new Review(2, "title2", "image2", "category2", "content2");
		assertThat(allReviews, containsInAnyOrder(default1, default2));
	}
}
