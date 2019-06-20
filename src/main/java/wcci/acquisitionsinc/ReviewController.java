package wcci.acquisitionsinc;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {

	@Resource
	ReviewRepository reviewRepo;

	@RequestMapping({ "/all-reviews/", "/all-reviews" })
	public String findAll(Model model) {
		model.addAttribute("reviewsAttribute", reviewRepo.findAll());
		return "reviewsTemplate";
	}

//	@RequestMapping({ "/reviews/{id}", "/reviews/{id}/" })
//	public String getReview (Model model) {
//		model.addAttribute("review", reviewRepo.getReview());
//		return "review";
//	}
//
//	public void addReview(Review review) {
//		reviewRepo.addReview(review);
//
//	}

}
