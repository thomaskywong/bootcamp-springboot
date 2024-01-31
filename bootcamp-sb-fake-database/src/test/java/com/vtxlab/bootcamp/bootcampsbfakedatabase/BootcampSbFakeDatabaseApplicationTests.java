package com.vtxlab.bootcamp.bootcampsbfakedatabase;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Simulate the actual process of "mvn spring-boot:run"
// Testing @SpringBootApplcation -> @CompenentScan + @Autowired
// implements all component dependency validation!
// To trigger @SpringBootTest, we use "mvn clean test" - already test the server and launch 
@SpringBootTest
class BootcampSbFakeDatabaseApplicationTests {

	// In @SpringBootTest environment, the spring context will contains all my custom beans such as 
	// @Controller, @Service, @Configuration, @Bean

	// At least one @test to launch the test environment 
	// Spring context load - loading beans
	@Test
	void contextLoads() {
	}

}
