package com.vtxlab.bootcamp.bootcampsbforum.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// Customize Annotation 
// In java.lang (Java JDK)

// Add dependency. Since beginnering of Spring Boot 
// <dependency>
//    <groupId>org.springframework.boot</groupId>
//    <artifactId>spring-boot-starter-validation</artifactId>
// </dependency>


@Documented  // Declare Annotation Interface for customized annotation
@Target({ElementType.FIELD, ElementType.PARAMETER}) // define locations on where this customized annotation can be used
@Retention(RetentionPolicy.RUNTIME) // Annotation validation period
@Constraint(validatedBy = UserIdValidator.class) // implements contraint logic for value validation, defined in UserIdValidator (implements ConstraintValidator)
public @interface UserIdChecker {  // interface that implements annotation

  // Customized 3 attributes
  public String message() default "Invalid User Id. Please try again.";

  public Class<?>[] groups() default {};

  public Class<? extends Payload>[] payload() default {};
  
}
