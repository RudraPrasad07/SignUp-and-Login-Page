package com.example.demo1.Exception;

public class MethodArgumentNotValidException extends RuntimeException {
	public MethodArgumentNotValidException(String m) {
		super(m);
	}
}
