package wcci.acquisitionsinc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ReviewTest {

	Review underTest;
	Review underTest2;
	Category category;
	ReviewTag reviewTag;
	ReviewTag reviewTag2;

	@Before
	public void initialize() {
		category = new Category("food");
		reviewTag = new ReviewTag();
		reviewTag2 = new ReviewTag();
		underTest = new Review("Title", "www.github.io", "Content");
	}

	@Test
	public void constructorShouldHaveAllAtributes() {
		long underTestID = underTest.getId();
		String underTestTitle = underTest.getTitle();
		String underTestImageUrl = underTest.getImageUrl();
		String underTestContent = underTest.getContent();
		assertEquals(0, underTestID);
		assertThat(underTestTitle, is("Title"));
		assertThat(underTestImageUrl, is("www.github.io"));
		assertThat(underTestContent, is("Content"));
	}
}
