package wcci.acquisitionsinc;

import java.util.List;

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
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@Resource
	private ReviewTagRepository reviewTagRepo;

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
	public String addReview(String title, String imageUrl, String categoryString, String content, String reviewTagsString) {
		
		Category category = new Category(categoryString);
		String[] reviewTagsStringArray = reviewTagsString.split(",");
		ReviewTag[] reviewTags = new ReviewTag[reviewTagsStringArray.length];
		for (int i = 0; i < reviewTagsStringArray.length; i++) {
			reviewTags[i] = new ReviewTag(reviewTagsStringArray[i]);
		}
		
		reviewRepo.save(new Review(title, imageUrl, category, content));
		
		return "redirect:/all-reviews";
	}
	

}
