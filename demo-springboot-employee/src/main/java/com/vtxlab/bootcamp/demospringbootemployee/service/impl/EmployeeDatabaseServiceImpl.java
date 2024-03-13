package com.vtxlab.bootcamp.demospringbootemployee.service.impl;

import com.vtxlab.bootcamp.demospringbootemployee.database.EmployeeDatabase;
import com.vtxlab.bootcamp.demospringbootemployee.model.Employee;
import com.vtxlab.bootcamp.demospringbootemployee.service.EmployeeDatabaseService;

public class EmployeeDatabaseServiceImpl implements EmployeeDatabaseService  {

  @Override
  public Employee getEmployeeDatabase(int index) {
    return EmployeeDatabase.getDatabase(index);
  }

  @Override
  public void setEmployeeDatabase(int index, String name, double salary) {
    EmployeeDatabase.setDatabase(index, new Employee(name, salary));
  }
  
}
