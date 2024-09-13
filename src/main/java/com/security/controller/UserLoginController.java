package com.security.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.User;
import com.security.model.UserLoginRequest;
import com.security.model.UserLoginResponse;
import com.security.service.UserLoginServices;
import com.security.util.JwtLoginUtil;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserLoginController {
	@Autowired
	UserLoginServices loginservices;

	@Autowired
	JwtLoginUtil util;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/user/save")
	public User saveUser(@RequestBody User user) {
		User pr = loginservices.loginsave(user);
		System.out.println("save operation");
		return pr;
	}

	@PostMapping("/user/login")
	public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest req)
	{
		System.out.println("controller");
		System.out.println("reqqq" + req);
//		 validate un/pwd with database
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(req.getUserName(), req.getPassword()));
		System.out.println("controller2");
		String token = util.generateToken(req.getUserName());
		return ResponseEntity.ok(new UserLoginResponse(token, "success"));
	}

//3. after login only
	@PostMapping("/user/welcome")
	public ResponseEntity<String> accessData(Principal p) {
		System.out.println("welcome URl");
		return ResponseEntity.ok("Hello User!" + p.getName());
	}
}
