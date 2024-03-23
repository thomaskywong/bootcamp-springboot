package com.vtxlab.bootcamp.practisesbthymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Coin {

  private Integer id;
  private String name;
  private Double curPrice; 
  
}
