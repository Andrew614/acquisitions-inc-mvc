package wcci.acquisitionsinc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping({"/{id}","/{id}/"})
	public String getCategory(@PathVariable("id")Long id, Model model) {
		model.addAttribute("categoryAttribute", categoryRepo.findById(id).get().getReviews());
		return "categoryTemplate";
	}
	
	@PostMapping({"/add-category", "/add-category/"})
	public String addCategory(String name) {
		Category categoryToAdd = new Category(name);
		if (categoryRepo.findByName(categoryToAdd.getName()) == null) {
			categoryRepo.save(categoryToAdd);
	        }	
		
		return "redirect:/all-categories";
	}

}
