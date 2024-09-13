package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.security.fillter.UserLoginSecurityFillter;

@Configuration
@EnableWebSecurity
public class SecurityLoginConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private CustomOAuth2UserService userService;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	InvaildLoginUserAuthEntryPoint authenticationEntryPoint;

	@Autowired
	private UserLoginSecurityFillter userLoginSecurityFillter;

	@SuppressWarnings("deprecation")
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {

		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		System.out.println("AuthenticationManager class");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("authorization");
		http.cors();
		http.csrf().disable().authorizeRequests().antMatchers("/**","/user/save", "/user/login").permitAll().anyRequest()
				.authenticated().and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				// register filter for 2nd request onwards..
				.and().addFilterBefore(userLoginSecurityFillter, UsernamePasswordAuthenticationFilter.class);
//		.oauth2Login().loginPage("/login").userInfoEndpoint().userService(userService);

		System.out.println("authorization end");

	}

}
