package wcci.acquisitionsinc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/all-tags", "/all-tags/"})
public class ReviewTagController {
	
	@Autowired
	private ReviewTagRepository reviewTagRepo;
	
	@RequestMapping({"/", ""})
	public String findAll(Model model) {
		model.addAttribute("reviewTagAttribute", reviewTagRepo.findAll());
		return "reviewTagTemplate";
	}
}
