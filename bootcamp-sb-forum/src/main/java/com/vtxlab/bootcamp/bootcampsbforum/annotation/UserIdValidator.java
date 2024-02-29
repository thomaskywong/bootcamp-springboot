package com.vtxlab.bootcamp.bootcampsbforum.annotation;

import java.util.Objects;
import com.vtxlab.bootcamp.bootcampsbforum.dto.request.UserIdRQDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


//
public class UserIdValidator implements ConstraintValidator<UserIdChecker, UserIdRQDTO> {

  @Override
  public boolean isValid(UserIdRQDTO dto, ConstraintValidatorContext context) {

    if (!Objects.nonNull(dto)){
      return false;
    }

    try {
      Integer i = Integer.valueOf(dto.getId());
      return i > 0 ;
    } catch (NumberFormatException ex) {
      return false; // other string. Return true or false to ConstraintValidator interface
    }

    // false -> Spring program throw ConstraintVioationException -> GEH -> ApiResposne
  }
  
}
