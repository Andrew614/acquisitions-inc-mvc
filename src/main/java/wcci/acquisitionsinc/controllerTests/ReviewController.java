package wcci.acquisitionsinc.controllerTests;

import java.util.Collection;

import wcci.acquisitionsinc.Review;
import wcci.acquisitionsinc.ReviewRepository;

public class ReviewController {

	
	ReviewRepository reviewRepo = new ReviewRepository();
	
	public Collection<Review> getReviews() {
		return reviewRepo.getAllReviews();
	}

	public Review getReview(long id) {
		return reviewRepo.getReview(id);
	}

}
