package wcci.acquisitionsinc;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

import java.util.Collection;

import org.junit.Before;

public class ReviewRepositoryTest {

	Review underTest = new Review(1, "title", "imageUrl", "category", "content");
	Review underTest2 = new Review(2, "title2", "imageUrl2", "category2", "content2");
	Review underTest3 = new Review(3, "title3", "imageUrl3", "category3", "content3");
	Review underTest4 = new Review(4, "title4", "imageUrl4", "category4", "content4");
	Review underTest5 = new Review(4, "title4", "imageUrl4", "category4", "content4");
	ReviewRepository repository = new ReviewRepository();

	@Before
	public void initalize() {
		ReviewRepository repository = new ReviewRepository();
		Review underTest = new Review(1, "title", "imageUrl", "category", "content");
		Review underTest2 = new Review(2, "title2", "imageUrl2", "category2", "content2");
		Review underTest3 = new Review(3, "title3", "imageUrl3", "category3", "content3");
		Review underTest4 = new Review(4, "title4", "imageUrl4", "category4", "content4");
	}

	@Test
	public void shouldBeAbleToAddReviewAndGet() {
		repository.addReview(underTest);
		Review retrivedReview = repository.getReview(1);
		assertThat(retrivedReview, is(underTest));
	}

	@Test
	public void shouldBeAbleToGetAllReviews() {
		repository.addReview(underTest3);
		repository.addReview(underTest4);
		repository.addReview(underTest);
		repository.addReview(underTest2);
		Collection<Review> allReviews = repository.getAllReviews();
		assertThat(allReviews, hasItem(underTest));
		assertThat(allReviews, hasItem(underTest2));
		assertThat(allReviews, hasItem(underTest3));
		assertThat(allReviews, hasItem(underTest4));
	}
}








