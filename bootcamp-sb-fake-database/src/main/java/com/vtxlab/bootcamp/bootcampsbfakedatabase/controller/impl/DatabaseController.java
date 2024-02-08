package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.config.AppConfig;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.DatabaseOperation;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v1")
public class DatabaseController implements DatabaseOperation {


  @Autowired // （required = false) // dependency injection
  // polymophism
  private CatDatabaseService catDatabaseService;

  @Autowired
  @Qualifier(value = "config1")
  private CharSequence appConfig;

  @Autowired
  @Qualifier(value = "bean3")
  private Integer age;

  @Override
  public CharSequence tutor() {
    return this.appConfig;
  }

  @Override
  public Integer age() {
    return this.age;
  }

  // GetMapping
  @Override
  public Cat getCat(int index) {
    // return new CatDatabaseServiceImpl().getCatFromStaticMemory(index);
    return this.catDatabaseService.getCatFromStaticMemory(index);
  }

  @Override
  public void setCat(int index, String name, int age) {
    // new CatDatabaseServiceImpl().setCatToStaticMemory(index,
    // new Cat(name, age));
    this.catDatabaseService.setCatToStaticMemory(index, new Cat(name, age));
  }

  // PostMapping
  @Override
  public Cat createCat(int idx, Cat cat) {
    return this.catDatabaseService.createCatToStaticMemory(idx, cat);
  }

  // DeleteMapping
  @Override
  public Boolean deleteCat(int idx) {
    return this.catDatabaseService.deleteCatFromStaticMemory(idx);
  }

  // PutMapping
  @Override
  public Cat putCat(int idx, Cat cat) {
    return this.catDatabaseService.putCatToStaticMemory(idx, cat);
  }

  // PatchMapping
  @Override
  public Cat patchCat(int idx, String name) {
    return this.catDatabaseService.patchCatToStaticMemory(idx, name);
  }

  @Override
  public Cat patchCat(int idx, int age) {
    return this.catDatabaseService.patchCatToStaticMemory(idx, age);
  }

  @Override
  public List<Cat> getCats() {
    return this.catDatabaseService.getCats();
  }

  // getCat2
  @Override
  public Cat getCat2(int index) {
    return this.catDatabaseService.getCatFromStaticMemory(index);
  }

}
