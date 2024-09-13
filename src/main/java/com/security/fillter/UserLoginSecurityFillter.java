package com.security.fillter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.security.util.JwtLoginUtil;

@Component
//fillter are used sendrequest so  are login successfully that person only see this welcome page
public class UserLoginSecurityFillter extends OncePerRequestFilter

{
	@Autowired
	private JwtLoginUtil utill;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 1. read token from Auth head
		String token = request.getHeader("Authorization");
		if (token != null) {
			// do validation
			String userName = utill.getUserName(token);

			// username should not be empty, conext-auth must be empty
			if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				UserDetails usr = userDetailsService.loadUserByUsername(userName);

				// validate token
				boolean isValid = utill.validateToken(token, usr.getUsername());

				if (isValid) {
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userName,
							usr.getPassword(), usr.getAuthorities());

					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					// final object stored in SecurityContext with User Details(un,pwd)
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
		}
		filterChain.doFilter(request, response);

	}

}
