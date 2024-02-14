package com.vtxlab.bootcamp.bootcampsbforum.infra;

import lombok.Getter;

@Getter
public enum Syscode {

  OK("000000", "OK."), //
  INVALID_CURRENCY("100000","Invalid Input Currency."), //
  JPH_NOT_AVAILABLE("100001","JsonPlaceHolder API not available."), //
  NOTFOUND("100002","Resources Not Found."), //
  REST_CLIENT_EXEPTION("900001", "RestClient Exception."), //
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
