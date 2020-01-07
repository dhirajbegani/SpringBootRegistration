package com.practice.test.registration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

	@RequestMapping("/")
    public String welcome() {
        return "Welcome to registration page"; 
    }
 

}
