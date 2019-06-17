package wcci.acquisitionsinc.controllerTests;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wcci.acquisitionsinc.ReviewRepository;

@Controller
public class ReviewController {

	@Resource
	ReviewRepository reviewRepo;
	
	@RequestMapping({"/reviews/","/reviews"})
	public @ResponseBody String getReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.getAllReviews());
		return "reviews";
	}
	
	@RequestMapping({"/reviews/1","/reviews/1/"})
	public String getReview(long id, Model model) {
		model.addAttribute("review", reviewRepo.getReview(id));
		return "review";
	}

}
