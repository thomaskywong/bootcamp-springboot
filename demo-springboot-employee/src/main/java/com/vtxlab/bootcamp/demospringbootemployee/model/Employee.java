package com.vtxlab.bootcamp.demospringbootemployee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Employee {

  private String name;
  private double salary;
  
}
