package com.vtxlab.bootcamp.demospringbootemployee.service;

import com.vtxlab.bootcamp.demospringbootemployee.model.Employee;

public interface EmployeeDatabaseService {

  Employee getEmployeeDatabase(int index);

  void setEmployeeDatabase(int index, String name, double salary);
  
}
