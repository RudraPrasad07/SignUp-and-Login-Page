package com.example.demo1.Service;

import com.example.demo1.dto.LoginDTO;
import com.example.demo1.dto.UserDTO;
import com.example.demo1.entity.User;
import com.example.demo1.utill.ResponseStructure;

public interface UserService {
	ResponseStructure<String> save(UserDTO u);
	
	ResponseStructure<String> login(LoginDTO dto);
}
