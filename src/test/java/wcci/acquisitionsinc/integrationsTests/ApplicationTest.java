package wcci.acquisitionsinc.integrationsTests;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import wcci.acquisitionsinc.CategoryRepository;
import wcci.acquisitionsinc.Review;
import wcci.acquisitionsinc.ReviewRepository;
import wcci.acquisitionsinc.ReviewTagRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {
	
	private void assertThatStatusIsOk(String mapping) throws Exception {
		ResultActions performMockGetRequest = this.mockMvc.perform(get(mapping));
		ResultActions response = performMockGetRequest.andDo(print());
		response.andExpect(status().isOk());
	}

	@Resource
	private MockMvc mockMvc;
	
	@Resource
	private ReviewRepository reviewRepo;
		
	@Test
	public void shouldReviewsStatusBeOk() throws Exception {
		assertThatStatusIsOk("/all-reviews");
	}

	@Test
	public void shouldReviewStatusBeOk() throws Exception {
		Iterable<Review> reviews = reviewRepo.findAll();
		for(Review review: reviews) {
			assertThatStatusIsOk("/all-reviews/" + review.getId());
		}
	}
	
	@Test
	public void shouldAddReviewAndRedirect() throws Exception {
		ResultActions performMockPostRequest = this.mockMvc.perform(post("/all-reviews/add-review"));
		performMockPostRequest.andExpect(status().is3xxRedirection());
	}
}