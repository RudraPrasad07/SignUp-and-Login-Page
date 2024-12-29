package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthHubApplication.class, args);
		System.out.println("Hello");
	}

}
