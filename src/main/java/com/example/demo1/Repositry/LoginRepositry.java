package com.example.demo1.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.entity.Login;
import java.util.List;


public interface LoginRepositry extends JpaRepository<Login, Integer> {
	List<Login> findByEmail(String email);
	List<Login> findByEmailAndPassWord(String email, String passWord);

}
