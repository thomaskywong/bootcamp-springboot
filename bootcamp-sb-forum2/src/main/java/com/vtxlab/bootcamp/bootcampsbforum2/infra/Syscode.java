package com.vtxlab.bootcamp.bootcampsbforum2.infra;

import lombok.Getter;

@Getter
public enum Syscode {

  OK("000000", "OK."),
  NOTFOUND("100000","Not Found."),
  ;

  private String code;
  private String message;

  private Syscode (String code, String message) {
    this.code = code;
    this.message = message;
  }
  
}
