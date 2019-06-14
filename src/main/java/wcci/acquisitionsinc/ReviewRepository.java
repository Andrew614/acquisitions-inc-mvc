package wcci.acquisitionsinc;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {
	private static HashMap<Long, Review> reviews = new HashMap<Long, Review>();

	public ReviewRepository() {
		populateReviews();
	}

	public void addReview(Review review) {
		reviews.put(review.getId(), review);
	}

	public Review getReview(long id) {
		return reviews.get(id);
	}

	public Collection<Review> getAllReviews() {
		return reviews.values();
	}

	private void populateReviews() {
		addReview(new Review(1, "title", "image", "category", "content"));
		addReview(new Review(2, "title2", "image2", "category2", "content2"));
	}

}
