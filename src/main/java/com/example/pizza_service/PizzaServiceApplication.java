package com.example.pizza_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.pizza_service.entity"})
public class PizzaServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(PizzaServiceApplication.class, args);
	}

}
