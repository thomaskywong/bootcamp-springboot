package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

  // GetMapping
  @Override
  public Cat getCat(int index) {
    // return new CatDatabaseServiceImpl().getCatFromStaticMemory(index);
    return catDatabaseService.getCatFromStaticMemory(index);
  }

  @Override
  public void setCat(int index, String name, int age) {
    // new CatDatabaseServiceImpl().setCatToStaticMemory(index,
    // new Cat(name, age));
    catDatabaseService.setCatToStaticMemory(index, new Cat(name, age));
  }

  // PostMapping
  @Override
  public Cat createCat(int idx, Cat cat) {
    return catDatabaseService.createCatToStaticMemory(idx, cat);
  }

  // DeleteMapping
  @Override
  public Boolean deleteCat(int idx) {
    return catDatabaseService.deleteCatFromStaticMemory(idx);
  }

  // PutMapping
  @Override
  public Cat putCat(int idx, Cat cat) {
    return catDatabaseService.putCatToStaticMemory(idx, cat);
  }

  // PatchMapping
  @Override
  public Cat patchCat(int idx, String name) {
    return catDatabaseService.patchCatToStaticMemory(idx, name);
  }

  @Override
  public Cat patchCat(int idx, int age) {
    return catDatabaseService.patchCatToStaticMemory(idx, age);
  }

  @Override
  public List<Cat> getCats() {
    return catDatabaseService.getCats();
  }

    // getCat2
    @Override
    public Cat getCat2(int index) {
      return catDatabaseService.getCatFromStaticMemory(index);
    }

}
