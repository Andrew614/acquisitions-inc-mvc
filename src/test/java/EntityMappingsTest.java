import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

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
		Category food = new Category("food");
		Review review50 = new Review("review50", "", food, "");
		entityManager.persist(review50);
		entityManager.flush();
		Review foundReview = reviewRepo.findById(review50.getId()).get();
		assertThat(foundReview, is(review50));
	}

	@Test
	public void shouldSaveAndLoadCategory() {
		Review review50 = new Review("review50", "", corn, "");
		Review review51 = new Review("review51", "", corn, "");
		Review review52 = new Review("review52", "", bean, "");
		Review review53 = new Review("review53", "", tator, "");
		categoryRepo.save(review50);
		categoryRepo.save(review51);
		categoryRepo.save(review52);
		categoryRepo.save(review53);
		entityManager.flush();
		entityManager.clear();
		
		Review findReview = reviewRepo.findById(categoryRepo.)
	}

}
