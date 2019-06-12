package wcci.acquisitionsinc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {
	ReviewRepository reviewRepository = new ReviewRepository();

	@RequestMapping("/reviews/")
	public String getReviews(Model model) {
		reviewRepository.populateReviews();
		model.addAttribute("reviews", reviewRepository.getAllReviews());
		return "reviews";

	}

	@RequestMapping("/reviews/{id}")
	public String getReview(@PathVariable("id") long id, Model model) {
		model.addAttribute("review", reviewRepository.getReview(id));
		return "review";
	}
}
