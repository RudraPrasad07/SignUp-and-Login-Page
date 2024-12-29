package com.example.demo1.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo1.Exception.EmailallreadyExists;
import com.example.demo1.Exception.PasswordMissmatchError;
import com.example.demo1.Exception.PhoneNumberAllredayExists;
import com.example.demo1.Repositry.LoginRepositry;
import com.example.demo1.Repositry.UserLoginRepositry;
import com.example.demo1.Security.JwtTokenUtil;
import com.example.demo1.Service.UserService;
import com.example.demo1.dto.LoginDTO;
import com.example.demo1.dto.UserDTO;
import com.example.demo1.entity.Login;
import com.example.demo1.entity.User;
import com.example.demo1.utill.ResponseStructure;

import jakarta.transaction.Transactional;

@Service
public class UserSaveImpl implements UserService {
	@Autowired
	private UserLoginRepositry repositry;
	@Autowired
	private LoginRepositry loginRepositry;
	@Autowired
	private JwtTokenUtil util;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public ResponseStructure<String> save(UserDTO u) {
		if (!u.getPassword().equals(u.getConfirmPassword())) {
			throw new PasswordMissmatchError("Password does not match Confirm Password.");
		}

		if (repositry.existsByEmail(u.getEmail())) {
			throw new EmailallreadyExists("Email already exists...");
		}
		if (repositry.existsByPhoneNumber(u.getPhoneNumber())) {
			throw new PhoneNumberAllredayExists("Phone number already exists...");
		}
		if (u.getPassword().length() < 6 || u.getPassword().length() > 15) {
			throw new PasswordMissmatchError("Password length must be between 6 and 15 characters.");
		}
		if (u.getPhoneNumber().length() != 10) {
			throw new PasswordMissmatchError("PhoneNumber length must be 10.");
		}
		User user = new User();
		user.setUserName(u.getUserName());
		user.setEmail(u.getEmail());
		user.setName(u.getName() + " " + u.getLastName());
		user.setPhoneNumber(u.getPhoneNumber());
		user.setPassword(encoder.encode(u.getPassword()));
		String token = util.generateToken(u.getEmail());
		User savedUser = repositry.save(user);

		return new ResponseStructure<>(201, "User Saved Successfully In The Database", token, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<String> login(LoginDTO dto) {

	    List<Login> existingLogins = loginRepositry.findByEmail(dto.getEmail());

	    if (!existingLogins.isEmpty()) {
	        Login existingLogin = existingLogins.get(0);

	        if (encoder.matches(dto.getPassWord(), existingLogin.getPassWord())) {
	            existingLogin.setUpdateDate(LocalDateTime.now());
	            existingLogin.setLoggedIn(true);
	            loginRepositry.save(existingLogin);

	            return new ResponseStructure<>(200, "User Login Successful", null, LocalDateTime.now());
	        } else {
	            return new ResponseStructure<>(401, "Invalid password", null, LocalDateTime.now());
	        }
	    } else {
	        Login newLogin = new Login();
	        newLogin.setEmail(dto.getEmail());
	        newLogin.setPassWord(encoder.encode(dto.getPassWord()));
	        newLogin.setCreatedAt(LocalDateTime.now());
	        newLogin.setUpdateDate(LocalDateTime.now());
	        newLogin.setLoggedIn(true);

	        loginRepositry.save(newLogin);

	        return new ResponseStructure<>(201, "User Registered and Logged In Successfully", null, LocalDateTime.now());
	    }
	}

}
