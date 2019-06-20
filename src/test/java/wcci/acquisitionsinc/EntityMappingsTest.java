package wcci.acquisitionsinc;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

import wcci.acquisitionsinc.Category;
import wcci.acquisitionsinc.CategoryRepository;
import wcci.acquisitionsinc.Review;
import wcci.acquisitionsinc.ReviewRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EntityMappingsTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;

//	@Autowired
//	private Review review;

	@Test
	public void shouldSaveandLoadReview() {
		Category category = new Category("food");
		Review review50 = new Review("review50", "", category, "");
		entityManager.persist(category);
		entityManager.persist(review50);
		entityManager.flush();
		Review foundReview = reviewRepo.findById(review50.getId()).get();
		assertThat(foundReview.getTitle(), is("review50"));
	}

	@Test
	public void shouldSaveAndLoadCategory() {
		Category category = new Category("food");
		entityManager.persist(category);
		entityManager.flush();
		
		Category foundCategory = categoryRepo.findById(category.getId()).get();
		assertThat(foundCategory.getName(), is("food"));
	}

}
