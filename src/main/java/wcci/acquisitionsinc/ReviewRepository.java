package wcci.acquisitionsinc;

import java.util.Collection;
import java.util.HashMap;

public class ReviewRepository {
	private static HashMap<Long, Review> reviews = new HashMap<Long, Review>();

	public void addReview(Review review) {
		reviews.put(review.getId(), review);
	}

	public Review getReview(long id) {
		return reviews.get(id);
	}

	public Collection<Review> getAllReviews() {
		return reviews.values();
	}

	public void populateReviews() {
		addReview(new Review(1, "title", "image", "category", "content"));
		
	}

}
