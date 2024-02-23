package com.vtxlab.bootcamp.bootcampsbforum.polymorphism;

public interface Interfacable {

  public static final int CONSTANT_X = 10; // Constant

  // Default Method - for newly added method
  // Instant method 
  // Add new method, requires re-compilation of other classes that previously implements the interface without default method
  // default method does not required re-compilation of other classese that previously implements the interface
  default String hello() { // instance method
    return "Hello";
  }

  static String concat(String x, String y) {
    return x.concat(y);
  }

  
}
