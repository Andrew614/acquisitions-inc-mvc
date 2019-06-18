package wcci.acquisitionsinc.integrationsTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

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
		
	@Test
	public void shouldReviewsStatusBeOk() throws Exception {
		assertThatStatusIsOk("/reviews");
	}

	@Test
	public void shouldReviewStatusBeOk() throws Exception {
		assertThatStatusIsOk("/reviews/1");
	}
}