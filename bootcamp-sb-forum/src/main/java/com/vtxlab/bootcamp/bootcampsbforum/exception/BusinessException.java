package com.vtxlab.bootcamp.bootcampsbforum.exception;

import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import lombok.Getter;

@Getter
public class BusinessException extends Exception {

  private String code;

  public BusinessException(Syscode syscode) {
    super(syscode.getMessage());
    this.code = syscode.getCode();
  }

  
}
