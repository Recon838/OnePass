package com.raliev.onepass;

import com.raliev.onepass.service.SecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OnepassApplication {

	@Autowired
	private SecretService service;

	public static void main(String[] args) {
		SpringApplication.run(OnepassApplication.class, args);
	}
}
