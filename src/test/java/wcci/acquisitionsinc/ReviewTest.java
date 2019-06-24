package wcci.acquisitionsinc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ReviewTest {

	Review underTest;
	Review underTest2;
	Category category;
	ReviewTag reviewTag;

	@Before
	public void initialize() {
		category = new Category("food");
		reviewTag = new ReviewTag("fruit");
		underTest = new Review("Title", "www.github.io", category, reviewTag, "Content");
	}

	@Test
	public void constructorShouldHaveAllAtributes() {
		long underTestID = underTest.getId();
		String underTestTitle = underTest.getTitle();
		String underTestImageUrl = underTest.getImageUrl();
		String underTestContent = underTest.getContent();
		assertEquals(1, underTestID);
		assertThat(underTestTitle, is("Title"));
		assertThat(underTestImageUrl, is("www.github.io"));
		assertThat(underTestContent, is("Content"));
	}

}
