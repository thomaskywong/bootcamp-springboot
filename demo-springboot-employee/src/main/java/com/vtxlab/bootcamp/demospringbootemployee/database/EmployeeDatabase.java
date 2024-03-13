package com.vtxlab.bootcamp.demospringbootemployee.database;

import com.vtxlab.bootcamp.demospringbootemployee.model.Employee;

public class EmployeeDatabase {

  private static final int dbSize = 10;
  private static Employee[] employees = new Employee[dbSize];

  public static Employee getDatabase(int index) {
    if (index < 0 || index >= dbSize)
      throw new IllegalArgumentException("Invalid index value. index shall be between 0 and 9");

    return EmployeeDatabase.employees[index];
  }

  public static void setDatabase(int index, Employee employee) {
    if (index < 0 || index >= dbSize)
      throw new IllegalArgumentException("Invalid index value.");

    EmployeeDatabase.employees[index] = employee;
  }



}
