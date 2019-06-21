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

import wcci.acquisitionsinc.Category;
import wcci.acquisitionsinc.Review;
import wcci.acquisitionsinc.ReviewController;
import wcci.acquisitionsinc.ReviewRepository;

public class ReviewControllerTest {
	
	@InjectMocks
	
	private ReviewController underTest;
	@Mock
	private ReviewRepository repo;
	
	@Mock
	private Review reviewOne;
	Long reviewOneId = 1L;
	
	@Mock
	private Review reviewTwo;
	Long reviewTwoId = 2L;
	
	@Mock
	Model model;
	

	@Before
	public void setUp() {
		initMocks(this);
	}

//	@Test
//	public void shouldBeAbleToGetOneReview() {
//		String review = underTest.getReview(1, model);
//		assertThat(review, is("review"));
//	}

	@Test
	public void shouldBeAbleToGetReviews() {
		String reviews = underTest.findAll(model);
		assertThat(reviews, is("reviewsTemplate"));
	}

	@Test
	public void shouldHaveReviewsInModel() {
		Collection<Review> reviews = Arrays.asList(reviewOne, reviewTwo);
		Mockito.when(repo.findAll()).thenReturn(reviews);
		underTest.findAll(model);
		verify(model).addAttribute("reviewsAttribute", reviews);
	}
	
	
	


}
