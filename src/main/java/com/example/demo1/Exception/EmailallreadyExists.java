package com.example.demo1.Exception;

public class EmailallreadyExists extends RuntimeException {
	
	public EmailallreadyExists(String msg) {
		super(msg);
	}
}
