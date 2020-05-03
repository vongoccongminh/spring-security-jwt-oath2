package com.minh.springsecurityjwt.repository;

import com.minh.springsecurityjwt.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByEmail(String email);
	
}
