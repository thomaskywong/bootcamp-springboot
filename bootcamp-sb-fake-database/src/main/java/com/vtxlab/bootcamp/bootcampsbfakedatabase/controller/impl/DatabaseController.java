package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.DatabaseOperation;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.impl.CatDatabaseServiceImpl;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v1")
public class DatabaseController implements DatabaseOperation {

  @Override
  public Cat getCat(int index) {
    return new CatDatabaseServiceImpl().getCatFromStaticMemory(index);
  }

  @Override
  public void setCat(int index, String name, int age) {
    new CatDatabaseServiceImpl().setCattoStaticMemory(index, name, age);
  }
  
}
