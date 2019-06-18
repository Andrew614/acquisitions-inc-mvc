package wcci.acquisitionsinc.integrationsTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import wcci.acquisitionsinc.ReviewRepository;


@RunWith(SpringRunner.class)
@WebMvcTest
public class WebLayerTest {
	
	@Resource
	private MockMvc mockMvc;
	
	@MockBean
	private ReviewRepository reviewRepo;
	
	@Test
	public void shouldReturnReviewsPage() throws Exception {
		this.mockMvc.perform(get("/reviews")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturnReview1Page() throws Exception {
		this.mockMvc.perform(get("/reviews/1")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturnReview2Page() throws Exception {
		this.mockMvc.perform(get("/reviews/2")).andDo(print()).andExpect(status().isOk());
	}
	
}
