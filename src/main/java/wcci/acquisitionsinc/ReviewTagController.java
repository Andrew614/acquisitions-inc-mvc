package wcci.acquisitionsinc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/all-reviewTags", "/all-reviewTags/"})
public class ReviewTagController {
	
	@Autowired
	private ReviewTagRepository reviewTagRepo;
	
	@RequestMapping({"/", ""})
	public String findAll(Model model) {
		model.addAttribute("reviewTagAttribute", reviewTagRepo.findAll());
		return "reviewTagTemplate";
	}
	
	@PostMapping({"add-reviewTag", "add-reviewTag/"})
	public String addReviewTag(String name) {
		return "redirect:/all-reviewTags";
	}
}
