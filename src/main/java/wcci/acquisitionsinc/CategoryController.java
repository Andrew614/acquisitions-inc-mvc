package wcci.acquisitionsinc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/all-categories/","/all-categories"})
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@RequestMapping({"/",""})
	public String findAll(Model model) {
		model.addAttribute("categoryAttribute", categoryRepo.findAll());
		return "categoryTemplate";
	}
	
	@PostMapping({"/add-category", "/add-category/"})
	public String addCategory(String name) {
		return "redirect:/all-categories";
	}

}
