package wcci.acquisitionsinc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ReviewTest {

	Review underTest = new Review(1, "title", "imageUrl", "Category", "Content");

	@Before
	public void initialize() {
		Review underTest = new Review(0, "", "", "", "");
	}

	@Test
	public void reviewClassShouldExist() {
		Review underTest = new Review(0, "", "", "", "");
	}

	@Test
	public void reviewClassShouldHaveAnId() {
		Review underTest = new Review(0, "", "", "", "");
		long id = underTest.getId();
		assertEquals(0, id);
	}

	@Test
	public void reviewClass1ShouldHaveAnIdOf1() {
		Review underTest = new Review(1, "", "", "", "");
		long id = underTest.getId();
		assertEquals(1, id);
	}

	@Test
	public void reviewClassShouldHaveATitle() {
		Review underTest = new Review(0, "", "", "", "");
		String title = underTest.getTitle();
		assertEquals("", title);
	}

	@Test
	public void reviewClassShouldHaveATitleOfTitle() {
		Review underTest = new Review(0, "title", "", "", "");
		assertEquals("title", underTest.getTitle());
	}

	@Test
	public void reviewClassShouldHaveImageUrl() {
		String imageUrl = underTest.getImageUrl();
		assertEquals("imageUrl", imageUrl);
	}

	@Test
	public void shouldHaveReviewCategory() {
		String reviewCategory = underTest.getReviewCategory();
		assertEquals("Category", reviewCategory);
	}

	@Test
	public void shouldHaveAContent() {
		String content = underTest.getContent();
		assertEquals("Content", content);
	}

	@Test
	public void constructorShouldHaveAllAtributes() {
		Review underTest = new Review(1, "Title", "www.github.io", "Category", "Content");
		long underTestID = underTest.getId();
		String underTestTitle = underTest.getTitle();
		String underTestImageUrl = underTest.getImageUrl();
		String underTestCategory = underTest.getReviewCategory();
		String underTestContent = underTest.getContent();
		assertEquals(1, underTestID);
		assertThat(underTestTitle, is("Title"));
		assertThat(underTestImageUrl, is("www.github.io"));
		assertThat(underTestCategory, is("Category"));
		assertThat(underTestContent, is("Content"));

	}

}
