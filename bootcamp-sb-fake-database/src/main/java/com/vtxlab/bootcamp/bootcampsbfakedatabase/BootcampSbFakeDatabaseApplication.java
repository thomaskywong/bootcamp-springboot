package com.vtxlab.bootcamp.bootcampsbfakedatabase;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootcampSbFakeDatabaseApplication {
	static ConfigurableApplicationContext cac;
	
	public static void main(String[] args) {

		SpringApplication.run(BootcampSbFakeDatabaseApplication.class, args);


	}

}
