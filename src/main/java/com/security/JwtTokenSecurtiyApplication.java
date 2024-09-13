package com.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(scanBasePackages = "com.security,com.security.util,com.security.controller")

public class JwtTokenSecurtiyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtTokenSecurtiyApplication.class, args);
	}

}
