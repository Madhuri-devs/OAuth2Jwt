package com.security.model;

public class UserLoginResponse {
	private String token;
	private String message;
	public UserLoginResponse(String token, String message) {
		super();
		this.token = token;
		this.message = message;
	}
	@Override
	public String toString() {
		return "UserLoginResponse [token=" + token + ", message=" + message + "]";
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
