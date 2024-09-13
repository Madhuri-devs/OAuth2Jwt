package com.security.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.GitHubUserDetails;
import com.security.model.User;
import com.security.service.GitHubOAuthService;
import com.security.service.UserLoginServices;

@RestController
@CrossOrigin("http://localhost:3000/")
public class AuthorizationController {
	@Autowired
	GitHubOAuthService gitHubOAuthService;

	@Autowired
	UserLoginServices loginservices;

	@PostMapping("/exchangeCodeForAccessToken")
	public String exchangeCodeForAccessToken(@RequestBody Map<String, String> codeMap) {
		String authorizationCode = codeMap.get("code");
		System.out.println("Authorization code received." + authorizationCode);

		// Exchange the authorization code for an access token
		String accessToken = gitHubOAuthService.exchangeCodeForAccessToken(authorizationCode);
//		System.out.println(">>>>>>>"+accessToken +"nnnnnnnnn");

		// Use the access token to fetch user details from GitHub's user API
		GitHubUserDetails userDetails = gitHubOAuthService.fetchUserDetails(accessToken);
		System.out.println("userDetails " + userDetails);

//		System.out.println(userDetails);
		User details = new User();

		details.setName(userDetails.getName());
		details.setUserName(userDetails.getLogin());
		details.setPassword(String.valueOf(userDetails.getId()));
		
		
		Set<String> userrole = new HashSet<>();
		userrole.add("user");

		details.setRoles(userrole);

		User pr = loginservices.loginsave(details);
		System.out.println("save operation"+pr);

		// You can now use the userDetails object to access the user's GitHub details.
		return accessToken;
	}

}
