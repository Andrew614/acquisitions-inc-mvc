package wcci.acquisitionsinc.controllerTests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import wcci.acquisitionsinc.Review;
import wcci.acquisitionsinc.ReviewRepository;

public class ReviewControllerTest {
	@InjectMocks
	ReviewController underTest;
	@Mock
	Model model;
	@Mock
	ReviewRepository repo;
	
	Review review1;
	Review review2;
	
	@Before
	public void initalizer() {
		initMocks(this);
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
	@Test
	public void shouldAddReviewsToModel() {
		Collection<Review> reviews = Arrays.asList(review1, review2);
		Mockito.when(repo.getAllReviews()).thenReturn(reviews);
		underTest.getReviews();
		verify(model).addAttribute("reviews", reviews);
		
	}
}
