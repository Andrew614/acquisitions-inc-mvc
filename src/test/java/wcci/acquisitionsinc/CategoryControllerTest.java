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

import wcci.acquisitionsinc.CategoryController;

public class CategoryControllerTest {
	
	@InjectMocks
	private CategoryController underTest;
	
	@Mock
	private CategoryRepository categoryRepo;
	
	@Mock
	private Category category;
	
	@Mock
	private Category category1;
	

	@Mock
	Model model;
	

	@Before
	public void setUp() {
		initMocks(this);
	}
	
	@Test
	public void shouldBeAbleToGetAllCategories() {
		String reviews = underTest.findAll(model);
		assertThat(reviews, is("categoryTemplate"));
	}
	
	@Test
	public void shouldHaveCategoriesInModel() {
		Collection<Category> categories = Arrays.asList(category, category1);
		Mockito.when(categoryRepo.findAll()).thenReturn(categories);
		underTest.findAll(model);
		verify(model).addAttribute("categoryAttribute", categories);
	}
	

}
