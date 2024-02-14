package com.vtxlab.bootcamp.bootcampsbforum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootcampSbForumApplication {

	
	public static void main(String[] args) {

		ConfigurableApplicationContext cac
			= SpringApplication.run(BootcampSbForumApplication.class, args);

		// String[] beans = cac.getBeanDefinitionNames();

		// for (String bean: beans) {
		// 	System.out.println("Bean=" + bean);
		// }	
		

	}

}
