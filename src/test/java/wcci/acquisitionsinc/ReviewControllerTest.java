package wcci.acquisitionsinc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

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
	
	private ReviewController underTest;
	@Mock
	private ReviewRepository reviewRepo;
	
	@Mock
	private Review reviewOne;
	
	@Mock
	private Review reviewTwo;
	
	@Mock
	Model model;
	

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void shouldBeAbleToGetOneReview() {
		Optional<Review> reviewOneOptional = Optional.of(reviewOne);
		Mockito.when(reviewRepo.findById(0L)).thenReturn(reviewOneOptional);
		underTest.getReview(0L, model);
		verify(model).addAttribute("reviewAttribute", reviewOne);
	}

	@Test
	public void shouldBeAbleToGetReviews() {
		String reviews = underTest.findAll(model);
		assertThat(reviews, is("reviewsTemplate"));
	}

	@Test
	public void shouldHaveReviewsInModel() {
		Collection<Review> reviews = Arrays.asList(reviewOne, reviewTwo);
		Mockito.when(reviewRepo.findAll()).thenReturn(reviews);
		underTest.findAll(model);
		verify(model).addAttribute("reviewsAttribute", reviews);
	}
	


}
