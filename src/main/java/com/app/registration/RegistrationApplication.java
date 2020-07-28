package com.app.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RegistrationApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(RegistrationApplication.class, args);
	}

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RegistrationApplication.class);
	}
}
