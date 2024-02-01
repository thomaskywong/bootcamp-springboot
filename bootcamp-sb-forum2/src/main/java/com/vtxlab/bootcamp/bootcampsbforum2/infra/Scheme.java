package com.vtxlab.bootcamp.bootcampsbforum2.infra;

public enum Scheme {

  HTTP,
  HTTPS,
  ;

  public static String lowerCase(Scheme scheme) {
    return scheme.name().toLowerCase();
  }
  
}
