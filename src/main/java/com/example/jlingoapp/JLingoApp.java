package com.example.jlingoapp;

import com.fasterxml.jackson.databind.ObjectMapper; // Add this import
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean; // Add this import

@SpringBootApplication
public class JLingoApp {

	public static void main(String[] args) {
		SpringApplication.run(JLingoApp.class, args);
	}

	// Add this method below main
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}