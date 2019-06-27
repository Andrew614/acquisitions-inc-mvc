package wcci.acquisitionsinc.integrationsTests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import wcci.acquisitionsinc.Category;
import wcci.acquisitionsinc.CategoryRepository;
import wcci.acquisitionsinc.Review;
import wcci.acquisitionsinc.ReviewRepository;
import wcci.acquisitionsinc.ReviewTag;
import wcci.acquisitionsinc.ReviewTagRepository;

@RunWith(SpringRunner.class)
@WebMvcTest
public class WebLayerTest {
	
	@Autowired
	ObjectMapper objectMapper;

	@Resource
	private MockMvc mockMvc;

	@MockBean
	private ReviewRepository reviewRepo;

	@MockBean
	private CategoryRepository categoryRepo;
	
	@MockBean
	private ReviewTagRepository reviewTagRepo;
	
	@Mock
	private ReviewTag reviewTag;

	@Mock
	private Category category;

	@Mock
	private Review review;

	@Mock
	private Review review2;

	@Test
	public void shouldReturnAllReviewsPage() throws Exception {
		this.mockMvc.perform(get("/all-reviews")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnReview1Page() throws Exception {
		Optional<Review> reviewOptional = Optional.of(review);
		when(reviewRepo.findById(1L)).thenReturn(reviewOptional);
		when(review.getCategory()).thenReturn(category);
		this.mockMvc.perform(get("/all-reviews/1")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnReview2Page() throws Exception {
		Optional<Review> reviewOptional = Optional.of(review2);
		when(reviewRepo.findById(2L)).thenReturn(reviewOptional);
		when(review2.getCategory()).thenReturn(category);
		this.mockMvc.perform(get("/all-reviews/2")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void addReview() throws Exception {
		
		Review reviewToAdd = new Review("", "", "");

		mockMvc.perform(post("/all-reviews/add-review").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(reviewToAdd)))
				.andExpect(status().is3xxRedirection());
	}

	@Test
	public void shouldReturnAllCategoriesPage() throws Exception {
		this.mockMvc.perform(get("/all-categories")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnAllTagsPage() throws Exception {
		this.mockMvc.perform(get("/all-reviewTags")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void shouldAddCategory() throws Exception {
		Category categoryToAdd = new Category("");
		mockMvc.perform(post("/all-categories/add-category").contentType(MediaType.APPLICATION_JSON).content(toJson(categoryToAdd)))
			.andExpect(status().is3xxRedirection());
	}
	
	@Test
	public void shouldAddReviewTag() throws Exception {
		ReviewTag reviewTagToAdd = new ReviewTag("");
		mockMvc.perform(post("/all-reviewTags/add-reviewTag").contentType(MediaType.APPLICATION_JSON).content(toJson(reviewTagToAdd)))
			.andExpect(status().is3xxRedirection());
	}
	
	private String toJson(Review reviewToAdd) {
		return reviewToAdd.getTitle();
	}
	
	private String toJson(Category category) {
		return category.getName();
	}
	
	private String toJson(ReviewTag reviewTag) {
		return reviewTag.getName();
	}

}
