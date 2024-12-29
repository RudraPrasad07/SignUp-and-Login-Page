package com.example.demo1.Repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo1.entity.User;
import java.util.List;


public interface UserLoginRepositry extends JpaRepository<User, Integer> {
	Optional<User> findByPassword(String password);
	boolean existsByPhoneNumber(String phoneNumber);
	boolean existsByEmail(String email);
	List<User> findByEmail(String email);

	
}
