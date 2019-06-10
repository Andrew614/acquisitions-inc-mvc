package wcci.acquisitionsinc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ReviewTest {

	Review underTest = new Review();

	@Before
	public void initialize() {
		Review underTest = new Review();
	}

	@Test
	public void reviewClassShouldExist() {
		Review underTest = new Review();
	}

	@Test
	public void reviewClassShouldHaveAnId() {
		Review underTest = new Review();
		int id = underTest.getID();
		assertEquals(0, id);
	}
	
	@Test
	public void reviewClass1ShouldHaveAnIdOf1() {
		Review underTest = new Review(1);
		int id = underTest.getID();
		assertEquals(1, id);
	}

	@Test
	public void reviewClassShouldHaveATitle() {
		String title = underTest.getTitle();
		assertEquals("", title);
	}
	
	@Test
	public void reviewClassShouldHaveATitleOfTitle() {
		Review underTest = new Review(1, "title");
		assertEquals("title", underTest.getTitle());
	}

	@Test
	public void reviewClassShouldHaveImageUrl() {
		String imageUrl = underTest.getImageUrl();
		assertEquals("", imageUrl);
	}

	@Test
	public void shouldHaveReviewCategory() {
		String reviewCategory = underTest.getReviewCategory();
		assertEquals("", reviewCategory);
	}

	@Test
	public void shouldHaveAContent() {
		String content = underTest.getContent();
		assertEquals("", content);
	}

}
