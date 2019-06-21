package wcci.acquisitionsinc;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {

	@Resource
	private ReviewRepository reviewRepo;

	@RequestMapping({ "/all-reviews/", "/all-reviews" })
	public String findAll(Model model) {
		model.addAttribute("reviewsAttribute", reviewRepo.findAll());
		return "reviewsTemplate";
	}

	@RequestMapping({ "/all-reviews/{id}", "/all-reviews/{id}/" })
	public String getReview (@PathVariable Long id, Model model) {
		model.addAttribute("reviewAttribute", reviewRepo.findById(id).get());
		return "reviewTemplate";
	}

//	@PostMapping("/add-review")
//	public String addReview(Review review, Category category) {
//		
//	}

}
