package com.app.registration.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.Greeting;
import com.app.registration.model.User;
import com.app.registration.service.RegistrationService;

@RestController
@CrossOrigin
public class RegistrationController {

	@Autowired
	private RegistrationService service;
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/hello-world")
	@ResponseBody
	public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	
	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId=user.getEmailId();
		if (tempEmailId !=null && !"".equals(tempEmailId)) {
			User userobj =service.fetchUserByEmailId(tempEmailId);
			if (userobj !=null) {
				throw new Exception("user with "+ tempEmailId+" already exists");
			}
			
		}
		User userObj=null;
		userObj=service.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	public User liginUser(@RequestBody User user) throws Exception {
		String tempEmailId=user.getEmailId();
		String tempPass=user.getPassword();
		
		User userObj=null;
		if (tempEmailId!=null &&tempPass!=null) {
			userObj=service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);

		}
		if (userObj==null) {
			throw new Exception("bad credentials");
		}

		return userObj;
		
	}
	
}
