package com.vtxlab.bootcamp.bootcampsbforum2.infra;

public enum Scheme {

  HTTP,
  HTTPS,
  ;

  public String lowerCase() {
    return this.name().toLowerCase();
  }
  
}
