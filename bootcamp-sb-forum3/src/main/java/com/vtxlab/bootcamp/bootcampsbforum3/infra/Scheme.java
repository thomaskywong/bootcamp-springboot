package com.vtxlab.bootcamp.bootcampsbforum3.infra;

public enum Scheme {

  HTTP,
  HTTPS,
  ;

  public String lowercase(){
    return this.name().toLowerCase();
  }
  
}
