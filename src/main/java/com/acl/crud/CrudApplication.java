package com.acl.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CrudApplication {
		public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
