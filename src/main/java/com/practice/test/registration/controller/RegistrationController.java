package com.practice.test.registration.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping(value = "/requestLogin/json", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> getJsonLoginCredntials(@RequestParam Optional<String> userName,
			@RequestParam Optional<String> password) {
		Map<String, Object> loginDetails = new HashMap<>();

		loginDetails.put("User Name", userName.orElseGet(() -> "not provided"));
		loginDetails.put("Password", password.orElseGet(() -> "not provided"));

		return loginDetails;
	}

	@GetMapping(value = "/requestLogin/html", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getHtmlLoginCredntials(@RequestParam Optional<String> userName,
			@RequestParam Optional<String> password) {
		return  "User Name: " + userName.orElseGet(() -> "not provided") + "<br> Password: " + password.orElseGet(() -> "not provided");	
}
}
