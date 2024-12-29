package com.example.demo1.Exception;

public class UserNotFoundExcception extends RuntimeException {
	public UserNotFoundExcception(String message) {
		super(message);
	}
}
