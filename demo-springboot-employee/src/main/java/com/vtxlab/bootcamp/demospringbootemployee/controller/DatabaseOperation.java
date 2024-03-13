package com.vtxlab.bootcamp.demospringbootemployee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.vtxlab.bootcamp.demospringbootemployee.model.Employee;


public interface DatabaseOperation {

  @GetMapping(value = "/employee/{index}")
  Employee getEmployeeDatabase(@PathVariable(name = "index") int index);

  @GetMapping(value = "/employee/index/{index}/name/{name}/salary/{salary}")
  void setEmployeeDatabase(@PathVariable int index, //
      @PathVariable String name, //
      @PathVariable double salary);

}
