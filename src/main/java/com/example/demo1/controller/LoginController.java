package com.example.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Service.UserService;
import com.example.demo1.dto.LoginDTO;
import com.example.demo1.utill.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/details")
public class LoginController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public ResponseEntity<ResponseStructure<String>> loginUser(@Valid @RequestBody LoginDTO dto) {
        ResponseStructure<String> responseStructure = service.login(dto);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }
}