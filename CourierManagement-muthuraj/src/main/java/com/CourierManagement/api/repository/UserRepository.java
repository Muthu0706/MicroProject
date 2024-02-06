package com.CourierManagement.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CourierManagement.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	

	boolean existsByEmail(String email);

	User findByUsername(String username);
	


}
