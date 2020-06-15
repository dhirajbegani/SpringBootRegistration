package com.practice.test.registration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class RegistrationApplicationTestWithoutAuth {

	@Autowired
	private TestRestTemplate template;
	
	@Test
	public void testUserAuthRequest_shouldFailAndReturn401() throws Exception {
		ResponseEntity<String> response = template.getForEntity("/requestLogin/html",String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
}


