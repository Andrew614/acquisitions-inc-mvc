package wcci.acquisitionsinc.controllerTests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import wcci.acquisitionsinc.Review;
import wcci.acquisitionsinc.ReviewController;
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
	Review review50;

	@Before
	public void initalizer() {
		initMocks(this);
		review1 = new Review(1, "title", "image", "category", "content");
		review2 = new Review(2, "title2", "image2", "category2", "content2");
	}

	@Test
	public void shouldBeAbleToGetOneReview() {
		String review = underTest.getReview(1, model);
		assertThat(review, is("review"));
	}

	@Test
	public void shouldBeAbleToGetReviews() {
		String reviews = underTest.getReviews(model);
		assertThat(reviews, is("reviews"));
	}

	@Test
	public void shouldAddReviewsToModel() {
		Collection<Review> reviews = Arrays.asList(review1, review2);
		Mockito.when(repo.getAllReviews()).thenReturn(reviews);
		underTest.getReviews(model);
		verify(model).addAttribute("reviews", reviews);
	}

	@Test
	public void modelShouldContainReview1() {
		Mockito.when(repo.getReview(1)).thenReturn(review1);
		underTest.getReview(1, model);
		verify(model).addAttribute("review", review1);

	}
	
	@Test
	public void modelShouldContainReview2() {
		Mockito.when(repo.getReview(2)).thenReturn(review2);
		underTest.getReview(2, model);
		verify(model).addAttribute("review", review2);
	}
	@Test
	public void shouldAddReview50() {
		review50 = new Review(50, "title50", "image50", "category50", "content50");
		underTest.addReview(review50);
		String obtainedReview = underTest.getReview(50, model);
		assertThat(obtainedReview, is("review"));
	}
}
