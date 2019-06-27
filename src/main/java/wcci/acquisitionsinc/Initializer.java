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
	
	@Autowired
	private ReviewTagRepository reviewTagRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Category category1 = new Category("First Category");
		categoryRepo.save(category1);
		
		Category category2 = new Category("Second Category");
		categoryRepo.save(category2);
		
		ReviewTag reviewTag1 = new ReviewTag("Tag1");
		reviewTagRepo.save(reviewTag1);
		
		ReviewTag reviewTag2 = new ReviewTag("Tag2");
		reviewTagRepo.save(reviewTag2);
		
		Review review = new Review("review50", null, null);
		reviewRepo.save(review);
		
		Review review2 = new Review("review2", null, null);
		reviewRepo.save(review2);
		
		review.addCategory(category1);
		review.addReviewTag(reviewTag1);
		reviewRepo.save(review);
		
		review2.addCategory(category2);
		review2.addReviewTag(reviewTag1);
		review2.addReviewTag(reviewTag2);
		reviewRepo.save(review2);
//		Review review3 = new Review("review50", null, category2, null, reviewTag1);
//		Review review4 = new Review("review2", null, category2, null, reviewTag2);
		
		
		
		
		
	

	}

}
