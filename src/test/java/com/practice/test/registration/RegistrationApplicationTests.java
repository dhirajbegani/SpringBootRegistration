package com.practice.test.registration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegistrationApplicationTests {

	@Autowired
	private TestRestTemplate template;

	@Test
	public void testUserAuthRequestHtml_shouldSucceedWith200() throws Exception {
		ResponseEntity<String> response = template.withBasicAuth("user", "pa$$word").getForEntity("/requestLogin/html",
				String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	public void testAdminAuthRequest_shouldSucceedAndReturnHello() throws Exception {
		ResponseEntity<String> response = template.withBasicAuth("admin", "pa$$word").getForEntity("/",
				String.class);
		assertTrue(response.getBody().contains("Hello"));
	}
	
	@Test
	public void testUserAuthRequest_shouldFailAndReturn401() throws Exception {
		ResponseEntity<String> response = template.withBasicAuth("user", "wrongPassword").getForEntity("/",
				String.class);
		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
	}
	
	@Test
	public void testHealthOfApp_shouldReturnPass() throws Exception {
		ResponseEntity<String> response = template.withBasicAuth("user", "pa$$word").getForEntity("/actuator/health",
				String.class);
		assertTrue(response.getBody().contains("UP"));
	}
	
	/*@Test
	public void testHttpClient_shouldReturnPass() throws Exception {
		
		HttpClientRequest.getClientRequestResult();
		
		assertTrue(HttpClientRequest.getClientRequestResult().contains("not provided"));
	}*/
}
