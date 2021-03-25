package com.banking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
	
	
	@RequestMapping("/hello")
	public String getMessage() {
		return "Hello User! Welcome to Cloud Config Server";
	}
	

}
