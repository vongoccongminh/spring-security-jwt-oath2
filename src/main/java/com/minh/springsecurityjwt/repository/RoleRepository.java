package com.minh.springsecurityjwt.repository;

import com.minh.springsecurityjwt.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByName(String name);
	
}
