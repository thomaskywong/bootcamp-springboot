package com.vtxlab.bootcamp.demospringbootemployee.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vtxlab.bootcamp.demospringbootemployee.controller.DatabaseOperation;
import com.vtxlab.bootcamp.demospringbootemployee.model.Employee;
import com.vtxlab.bootcamp.demospringbootemployee.service.impl.EmployeeDatabaseServiceImpl;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v1")
public class DatabaseController implements DatabaseOperation {

  @Override
  public Employee getEmployeeDatabase(int index) {
    return new EmployeeDatabaseServiceImpl().getEmployeeDatabase(index);
  }

  @Override
  public void setEmployeeDatabase(int index, String name, double salary) {
    new EmployeeDatabaseServiceImpl().setEmployeeDatabase(index, name, salary);
  }

  
}
