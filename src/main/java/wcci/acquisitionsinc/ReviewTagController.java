package wcci.acquisitionsinc;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/all-reviewTags", "/all-reviewTags/"})
public class ReviewTagController {
	
	@Autowired
	private ReviewTagRepository reviewTagRepo;
	
	@Resource
	private ReviewRepository reviewRepo;
	
	@RequestMapping({"/", ""})
	public String findAll(Model model) {
		model.addAttribute("reviewTagsAttribute", reviewTagRepo.findAll());
		return "reviewTagsTemplate";
	}
	
	@RequestMapping({"/{id}","/{id}/"})
	public String getTag(@PathVariable("id")Long id, Model model) {
		model.addAttribute("reviewTagAttribute", reviewTagRepo.findById(id).get());
		return "reviewTagTemplate";
	}
	
	@PostMapping({"add-reviewTag", "add-reviewTag/"})
	public String addReviewTag(String name) {
		ReviewTag reviewTagToAdd = new ReviewTag(name);
		if (reviewTagRepo.findByName(reviewTagToAdd.getName()) == null) {
	            reviewTagRepo.save(reviewTagToAdd);
	        }	
		return "redirect:/all-reviewTags";
	}
}
