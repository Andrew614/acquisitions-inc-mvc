package wcci.acquisitionsinc;

import java.util.HashMap;

public class ReviewRepository {
	HashMap<Long, Review> reviews = new HashMap<Long, Review>();

	public void addReview(Review review) {
		reviews.put(review.getId(), review);
	}

	public Review getReview(long id) {
		return reviews.get(id);
	}

	public HashMap<Long, Review> getAllReviews() {
		return reviews;
	}

}
