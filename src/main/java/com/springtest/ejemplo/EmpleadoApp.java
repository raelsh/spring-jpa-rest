package com.springtest.ejemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmpleadoApp {
	
	public static void main(String[] args) {
		SpringApplication.run(EmpleadoApp.class, args);
	}
}