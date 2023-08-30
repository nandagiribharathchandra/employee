package com.hcl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class EmployeeRestfulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestfulApiApplication.class, args);
	}

}
