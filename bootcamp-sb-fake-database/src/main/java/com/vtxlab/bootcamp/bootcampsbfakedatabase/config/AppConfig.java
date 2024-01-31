package com.vtxlab.bootcamp.bootcampsbfakedatabase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Annotation of a class that use @Bean to let @ComponentScan to include the method as Bean
// Use @AutoWired() + @Qualifier(value = "config1") to identify which bean to be loaded
@Configuration
public class AppConfig {
  
  @Bean(value = "config1")
  String tutorName() {
    return "Vincent";
  }

  @Bean(value = "config2")
  String tutorName2() {
    return "Oscar";
  }
  
}
