package wcci.acquisitionsinc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {
	@Autowired
	private ReviewRepository reviewRepo;

	@Override
	public void run(String... args) throws Exception {
		Review review = new Review("review50", null, null, null);
		Review review2 = new Review("review2", null, null, null);
		reviewRepo.save(review);
		reviewRepo.save(review2);

	}

}
