package com.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.model.GitHubUserDetails;
import com.security.model.User;

@Service
public class GitHubOAuthService {
	@Autowired
	RestTemplate restTemplate;

	@Value("${github.apiBaseUrl}")
	private String githubApiBaseUrl;

	@Value("${spring.security.oauth2.client.registration.github.client-id}")
	private String clientId;

	@Value("${spring.security.oauth2.client.registration.github.client-secret}")
	private String clientSecret;

	public GitHubOAuthService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String exchangeCodeForAccessToken(String code) throws RuntimeException {
		String tokenUrl = "https://github.com/login/oauth/access_token?";
		String responseBody = "";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		// Create the request body with the authorization code, client ID, and client
		// secret
		String requestBody = tokenUrl + "code=" + code + "&client_id=" + clientId + "&client_secret=" + clientSecret;
		System.out.println(requestBody + "  requestBody");
		try {

			Optional<ResponseEntity<String>> responseEntity = Optional
					.ofNullable(restTemplate.postForEntity(requestBody, null, String.class));

			if (responseEntity.isPresent())
				System.out.println(responseEntity + "responseEntity");
			else
				System.out.println("responseEntity is empty");

			if (responseEntity.get().getStatusCode().is2xxSuccessful()) {
				System.out.println("Status 200");
				// Parse the response body to extract status code, error, and error description
				responseBody = responseEntity.get().getBody();

				System.out.println(responseBody + " responseBody");

				String[] parts = responseBody.split("&");
				for (String part : parts) {
					if (part.startsWith("access_token=")) {
						System.out.println(part + "part");
						return part.substring("access_token=".length());
					}
				}

				if (responseBody.startsWith("error"))
					return "BAD Verification Code";

				return responseBody;

			}

		} catch (HttpClientErrorException e) {

			return "Http Client exception"; // Replace with appropriate error handling
		}
		return requestBody;

	}

	public GitHubUserDetails fetchUserDetails(String accessToken) {
		GitHubUserDetails details = null;

		try {
			HttpHeaders headers = new HttpHeaders();
//			headers.set("Authorization", accessToken);
			headers.set("Authorization", "Bearer " + accessToken);

//			headers.set("Authorization", String.format("Bearer "+ accessToken));
			System.out.println("authorisation header" + headers);

			RequestEntity<Void> requestEntity = RequestEntity.get(githubApiBaseUrl + "/user").headers(headers)
					.accept(MediaType.APPLICATION_JSON).build();
			System.out.println("fetch" + requestEntity);

			Optional<ResponseEntity<GitHubUserDetails>> responseEntity = Optional
					.ofNullable(restTemplate.exchange(requestEntity, GitHubUserDetails.class));
			if (responseEntity.get().getStatusCode().is2xxSuccessful()) {
				System.out.println(responseEntity.get());
//				System.out.println(responseEntity.get().getBody());
				details=responseEntity.get().getBody();
				System.out.println(details.toString());
//				ObjectMapper om = new ObjectMapper();
//				System.out.println(om.writeValueAsString(responseEntity.get().getBody()));
//				details = om.readValue(om.writeValueAsString(responseEntity.get().getBody()), GitHubUserDetails.class);
//				System.out.println(details.toString());
//				System.out.println(details = responseEntity.get().getBody());

				
				
			} else {
				// Handle the error case
				throw new RuntimeException("Failed to fetch user details");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return details;

	}
}
