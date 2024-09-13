package com.security.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.model.User;
import com.security.repo.UserLoginRepo;

@Service
public class UserLoginServices implements UserDetailsService {
	@Autowired
	UserLoginRepo loginRepo;

	@Autowired
	BCryptPasswordEncoder pwdEncoder;

	public User loginsave(User user) {
		// Encode Password
		user.setPassword(pwdEncoder.encode(user.getPassword()));
		return loginRepo.save(user);
	}
	
	private Optional<User> findByUserName(String userName) {
		// TODO Auto-generated method stub
		return loginRepo.findByUserName(userName);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<User> data =loginRepo.findByUserName(userName);
		System.out.println(">>>>>>>>>>>>>>"+data);
		
		if (data==null) {
			System.out.println("null");
			throw new UsernameNotFoundException("User not exist");
		}
		// read user (from DB)
		User user = data.get();
		System.out.println(">>>>>>>>>>>>>>"+user);
		
		return new org.springframework.security.core.userdetails.User(
				userName,
				user.getPassword(),
				user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList()));
		}

	
}
