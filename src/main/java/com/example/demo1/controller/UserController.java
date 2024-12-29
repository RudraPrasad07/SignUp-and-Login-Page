package com.example.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Security.JwtTokenUtil;
import com.example.demo1.Service.UserService;
import com.example.demo1.dto.UserDTO;
import com.example.demo1.entity.User;
import com.example.demo1.utill.ResponseStructure;

import javax.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	@Autowired
    private JwtTokenUtil jwtTokenUtil;
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<String>> postMethodName(@Valid @RequestBody UserDTO entity) {
		ResponseStructure<String> u=service.save(entity);
		return new ResponseEntity<ResponseStructure<String>>(u,HttpStatus.OK);
	}
	
}
