package com.jpacrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class JpaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaCrudApplication.class, args);
	}

}
