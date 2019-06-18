package wcci.acquisitionsinc;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {

	@Resource
	ReviewRepository reviewRepo;
	
	@RequestMapping({"/reviews/","/reviews"})
	public String getReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.getAllReviews());
		return "reviews";
	}
	
	@RequestMapping({"/reviews/{id}","/reviews/{id}/"})
	public String getReview(@PathVariable("id") long id, Model model) {
		model.addAttribute("review", reviewRepo.getReview(id));
		return "review";
	}

	public void addReview(Review review) {
		reviewRepo.addReview(review);
		
	}

}
