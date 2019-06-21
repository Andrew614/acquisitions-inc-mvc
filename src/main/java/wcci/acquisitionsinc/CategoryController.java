package wcci.acquisitionsinc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@RequestMapping({"/all-categories/","/all-categories"})
	public String findAll(Model model) {
		model.addAttribute("categoryAttribute", categoryRepo.findAll());
		return "categoryTemplate";
	}
	
	

}
