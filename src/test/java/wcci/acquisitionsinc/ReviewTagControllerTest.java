package wcci.acquisitionsinc;

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


import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;

public class ReviewTagControllerTest {
	
	@InjectMocks
	private ReviewTagController underTest;
	
	@Mock
	private ReviewTagRepository reviewTagRepo;
	
	@Mock
	private ReviewTag reviewTag1;
	
	@Mock
	private ReviewTag reviewTag2;
	
	@Mock
	Model model;
	
	@Before
	public void setUp() {
		initMocks(this);
	}
	
	@Test
	public void shouldBeAbleToGetAllReviewTags() {
		String reviews = underTest.findAll(model);
		assertThat(reviews, is("reviewTagTemplate"));
	}
	
	@Test
	public void shouldHaveReviewTagsInModel() {
		Collection<ReviewTag> reviewTags = Arrays.asList(reviewTag1, reviewTag2);
		Mockito.when(reviewTagRepo.findAll()).thenReturn(reviewTags);
		underTest.findAll(model);
		verify(model).addAttribute("reviewTagAttribute", reviewTags);
	}
}
