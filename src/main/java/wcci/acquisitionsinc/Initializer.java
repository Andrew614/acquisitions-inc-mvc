package wcci.acquisitionsinc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {
	@Autowired
	private ReviewRepository reviewRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private ReviewTagRepository reviewTagRepo;

	@Override
	public void run(String... args) throws Exception {

		Category category1 = new Category("Drinks");
		categoryRepo.save(category1);

		Category category2 = new Category("Sauces");
		categoryRepo.save(category2);

		Category category3 = new Category("Cars");
		categoryRepo.save(category3);

		ReviewTag reviewTag1 = new ReviewTag("Tea");
		reviewTagRepo.save(reviewTag1);

		ReviewTag reviewTag2 = new ReviewTag("Chinese");
		reviewTagRepo.save(reviewTag2);

		ReviewTag reviewTag3 = new ReviewTag("Spicy");
		reviewTagRepo.save(reviewTag3);
		
		ReviewTag reviewTag4 = new ReviewTag("Mercedes");
		reviewTagRepo.save(reviewTag4);
		
		Review review = new Review("Peace Tea", "https://bronzechains.files.wordpress.com/2011/01/peaceteafront.jpg",
				"Peace Tea comes in a 23 oz. can, which is pretty huge as far as canned beverages go.  And at 99 cents a can, it’s quite a bargain.  But does it taste good?  Yes, yes it does. It doesn’t have that overly tart and tangy flavor that many bottled and canned teas are plagued with.  I’m looking right at you, Lipton Brisk.  I want to drink tea, not tea with 8 cups of sour-ass citric acid in it.  So Peace Tea, good stuff.  The tangy flavor I hate is there in a very minimal qauntity, and it doesn’t bother me at all.  This stuff is flat (not a bad thing), and has no carbonation.  That’s just a heads-up, since so many people look for something fizzy when they reach into the coolers at the local convenience store.  That being said, this tea is pretty refreshing, and doesn’t taste overly sweet.  It goes down easily, and does leave a little bit of that tartness in my mouth that I believe comes from the tannins in the tea.  Correct me if I’m wrong.  Most importantly, it tastes like tea.  It’s a wonderful alternative to all the colas and carbonated drinks out there, which sometimes give me stomach discomfort.  Yeah, I’m getting old.  A lot of the sugared sodas out there are almost syrupy in their sweetness.  Mountain Dew and Pepsi are particuarly guilty of this, yet I still buy them on occasion.  It’s mostly out of habit. I buy a bottle, then quickly regret it.  Help me, Peace Tea.  You’re my only hope.");
		reviewRepo.save(review);

		Review review2 = new Review("Stir Fry Sauce", "https://bronzechains.files.wordpress.com/2009/01/szechuan.jpg",
				"The taste:  Definitely spicier than the average stir fry sauce, with moderate heat that builds slowly.  It doesn’t overpower the flavor at all, though.  There’s garlic in there, no doubt about it.  This sauce had everything a stir fry sauce should have, only with a pretty decent spicy kick.  I thought it was a bit sweeter than most sauces, but that helped balance out the saltiness.  There’s quite a bit of sodium in this sauce, surprise surprise.  If you like spicy, sweet stir fry, give this stuff a try.  It’s a good sauce, and I imagine it would work well as a table sauce, or basted on some chicken or seafood.  I’ve yet to try it a second time, but I’m betting it would be great in a number of applications.");
		reviewRepo.save(review2);
		
		Review review3 = new Review("Mercedes-Benz G-Class", "https://www.cstatic-images.com/car-pictures/xl/usc90mbs231a021001.png", "I love this vehicle so much that I’ve ordered a 2nd Gwagon! The power, design, comfort and bada$$ness is over the top. Totally different vehicle from the previous generation G.");

		
		review.addCategory(category1);
		review.addReviewTag(reviewTag1);
		reviewRepo.save(review);

		review2.addCategory(category2);
		review2.addReviewTag(reviewTag2);
		review2.addReviewTag(reviewTag3);
		reviewRepo.save(review2);
		
		review3.addCategory(category3);
		review3.addReviewTag(reviewTag4);
		reviewRepo.save(review3);
//		Review review3 = new Review("review50", null, category2, null, reviewTag1);
//		Review review4 = new Review("review2", null, category2, null, reviewTag2);

	}

}
