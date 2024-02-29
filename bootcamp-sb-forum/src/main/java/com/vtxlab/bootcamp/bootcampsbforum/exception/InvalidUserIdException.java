package com.vtxlab.bootcamp.bootcampsbforum.exception;

import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;

public class InvalidUserIdException extends NumberFormatException{

  public InvalidUserIdException(Syscode syscode) {
    super(syscode.getMessage());
  }
  
}
