package wcci.acquisitionsinc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {
	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public void run(String... args) throws Exception {
		Category category1 = new Category("First Category");
		Category category2 = new Category("Second Category");
		Review review = new Review("review50", null, category1 , null);
		Review review2 = new Review("review2", null, category1, null);
		Review review3 = new Review("review50", null, category2, null);
		Review review4 = new Review("review2", null, category2, null);
		
		categoryRepo.save(category1);
		categoryRepo.save(category2);
		reviewRepo.save(review);
		reviewRepo.save(review2);

	}

}
