package wcci.acquisitionsinc.integrationsTests;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
	@Resource
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	String endpoint;
	
	private void assertThatEndPointIsOk(String endpoint) {
		ResponseEntity<String> response = restTemplate.getForEntity(endpoint, String.class);
		HttpStatus status = response.getStatusCode();
		status.is2xxSuccessful();
	}
	
	private void assertThatEndPointIsRedirect(String mapping) {
		ResponseEntity<String> response = restTemplate.getForEntity(mapping, String.class);
		HttpStatus status = response.getStatusCode();
		status.is3xxRedirection();
	}
	
	@Test
	public void reviewsEndPointShouldBeOk() {
		assertThatEndPointIsOk("/all-reviews");
	}
	
	@Test 
	public void reviews1EndPointShouldBeOk() {
		assertThatEndPointIsOk("/all-reviews/1");
	}
	
	@Test	
	public void reviews2EndPointShouldBeOk() {
		assertThatEndPointIsOk("/all-reviews/2");
	}
	@Test
	public void addReviewsEndPointShouldBeRedirect() {
		String mapping = "/all-reviews/add-review";
		assertThatEndPointIsRedirect(mapping);
	}

	
	@Test
	public void categoriesEndPointShouldBeOk() {
		assertThatEndPointIsOk("/all-categories");
	}
	
	@Test
	public void categoryEndPointShouldBeOk() {
		assertThatEndPointIsOk("/all-categories/1");
	}
	
	@Test
	public void addCategoriesEndPointShouldBeRedirect() {
		assertThatEndPointIsRedirect("/all-categories/add-category");
	}
	
	@Test
	public void reviewTagsEndPointShouldBeOk() {
		assertThatEndPointIsOk("/all-reviewTags");
	}
	
	@Test
	public void reviewTagEndPointShouldBeOk() {
		assertThatEndPointIsOk("/all-reviewTags/1");
	}
	
	@Test
	public void addReviewTagEndPointShouldBeRedirect() {
		assertThatEndPointIsRedirect("/all-reviewTags/add-reviewTag");
	}
}
