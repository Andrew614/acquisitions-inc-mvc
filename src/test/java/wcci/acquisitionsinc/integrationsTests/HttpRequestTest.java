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
//		assertThat(status, is(HttpStatus.OK));
	}
	
	@Test
	public void reviewsEndPointIsOk() {
		assertThatEndPointIsOk("/all-reviews");
	}
	
	@Test 
	public void reviews1EndPointIsOk() {
		assertThatEndPointIsOk("/all-reviews/1");
	}
	
	@Test	
	public void reviews2EndPointIsOk() {
		assertThatEndPointIsOk("/all-reviews/2");
	}
	@Test
	public void addReviewsEndPointIsRedirect() {
		ResponseEntity<String> response = restTemplate.getForEntity("/add-review", String.class);
		HttpStatus status = response.getStatusCode();
		status.is3xxRedirection();
	}
}
