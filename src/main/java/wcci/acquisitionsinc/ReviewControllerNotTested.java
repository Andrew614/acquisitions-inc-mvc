//package wcci.acquisitionsinc;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//
//@RequestMapping({"/reviews","/reviews/"})
//public class ReviewController {
//
//	
//	@Resource
//	ReviewRepository reviewRepository;
//
//	@RequestMapping({"/", ""})
//	public String getReviews(Model model) {
//		model.addAttribute("reviews", reviewRepository.getAllReviews());
//		return "reviews";
//
//	}
//
//	@RequestMapping({"/{id}", "/{id}/"})
//	public String getReview(@PathVariable("id") long id, Model model) {
//		model.addAttribute("review", reviewRepository.getReview(id));
//		return "review";
//	}
//}
