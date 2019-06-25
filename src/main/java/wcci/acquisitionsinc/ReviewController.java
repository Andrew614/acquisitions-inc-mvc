package wcci.acquisitionsinc;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/all-reviews/", "/all-reviews" })
public class ReviewController {

	@Resource
	private ReviewRepository reviewRepo;

	@RequestMapping({"", "/"})
	public String findAll(Model model) {
		model.addAttribute("reviewsAttribute", reviewRepo.findAll());
		return "reviewsTemplate";
	}

	@RequestMapping({ "/{id}", "/{id}/" })
	public String getReview (@PathVariable("id") Long id, Model model) {
		model.addAttribute("reviewAttribute", reviewRepo.findById(id).get());
		return "reviewTemplate";
	}

	@PostMapping({"/add-review","/add-review/"}) 
	public String addReview(String title, String imageUrl, Category category, ReviewTag reviewTag, String content) {
		return "redirect:/all-reviews";
		
		
	}
	

}
