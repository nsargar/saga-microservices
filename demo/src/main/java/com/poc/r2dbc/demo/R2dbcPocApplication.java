package com.poc.r2dbc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class R2dbcPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(R2dbcPocApplication.class, args);
	}

}
