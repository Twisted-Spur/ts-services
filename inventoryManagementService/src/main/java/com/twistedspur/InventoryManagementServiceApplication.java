package com.twistedspur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class InventoryManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementServiceApplication.class, args);
	}

	@Bean
	public Function<String, String> reverseString() {
		System.out.println("called this function");
		return value -> new StringBuilder(value).reverse().toString();
	}
}
