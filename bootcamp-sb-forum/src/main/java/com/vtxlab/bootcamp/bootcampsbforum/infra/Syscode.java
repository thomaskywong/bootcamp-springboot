package com.vtxlab.bootcamp.bootcampsbforum.infra;

import lombok.Getter;

@Getter
public enum Syscode {

  OK("000000", "OK."), //
  NOTFOUND("100000","Not Found."), //
  JPH_NOT_AVAILABLE("100001","JsonPlaceHolder API not available."), //
  REST_CLIENT_EXEPTION("9000001", "RestClient Exception."), //
  NPE_EXCEPTION("900000","Runtime Exception - NPE"), //
  GENERAL_EXCEPTION("999999","Exception"), //
  ;

  private String code;
  private String message;

  private Syscode (String code, String message) {
    this.code = code;
    this.message = message;
  }
  
}
