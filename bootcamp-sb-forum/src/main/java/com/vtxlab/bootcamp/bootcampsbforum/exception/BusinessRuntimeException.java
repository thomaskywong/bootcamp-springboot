package com.vtxlab.bootcamp.bootcampsbforum.exception;

import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import lombok.Getter;


@Getter // provide getCode()
public class BusinessRuntimeException extends RuntimeException {

  private String code;

  public BusinessRuntimeException(Syscode syscode) {
    super(syscode.getMessage());
    this.code = syscode.getCode();
  }

  // BusinessRuntimeException -> RuntimeException -> Exception -> Throwable
  // subclass of Throwable:
  // 1. "throw" an object of this subclass
  // 2. catch the object thrown by method

  
}
