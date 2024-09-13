package com.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.security.model.User;

@Repository
public interface UserLoginRepo extends JpaRepository<User, Integer> {

	User save(User user);

	//@Query(value = "select * from bpclsave i WHERE i.user_name = ?1", nativeQuery = true)
	@Query(value = "SELECT * FROM users_data i WHERE i.user_name= ?1", nativeQuery = true)
	Optional<User> findByUserName(String userName);

}
