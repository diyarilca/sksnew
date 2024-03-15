package com.springback.sksbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SksBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SksBackendApplication.class, args);
	}

}
