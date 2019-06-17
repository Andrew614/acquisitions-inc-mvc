package wcci.acquisitionsinc.integrationsTests;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import wcci.acquisitionsinc.ReviewRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReviewsStatusBeOk() throws Exception {
		this.mockMvc.perform(get("/reviews")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void shouldReviewStatusBeOk() throws Exception {
		this.mockMvc.perform(get("/reviews/1")).andDo(print()).andExpect(status().isOk());
	}
	
	
	
	
	
	
}