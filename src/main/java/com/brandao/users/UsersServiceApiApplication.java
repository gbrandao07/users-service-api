package com.brandao.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
		"com.brandao.users"
})
public class UsersServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersServiceApiApplication.class, args);
	}
}
