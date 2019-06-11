package wcci.acquisitionsinc;

import java.util.HashMap;

public class ReviewRepository {
	HashMap<Integer, Review> reviews = new HashMap<Integer, Review>();

	public void addReview(Review review) {
		reviews.put(review.getID(), review);
	}

	public Review getReview(int id) {
		return reviews.get(id);
	}

}
