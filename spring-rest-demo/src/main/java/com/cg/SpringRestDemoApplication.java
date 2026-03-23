package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestDemoApplication.class, args);
	}
	
	@Bean
	public ObjectMapper getBean() {
		return new ObjectMapper();
	}
}
