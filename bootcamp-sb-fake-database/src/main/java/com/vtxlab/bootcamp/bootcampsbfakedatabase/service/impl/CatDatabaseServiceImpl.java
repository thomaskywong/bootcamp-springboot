package com.vtxlab.bootcamp.bootcampsbfakedatabase.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.database.CatDatabase;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

@Service
public class CatDatabaseServiceImpl implements CatDatabaseService {

  // Objectives of Service
  // 1. Data source
  // 2. The service you are going to provide

  @Override
  public Cat getCatFromStaticMemory(int index) {
    return CatDatabase.getCat(index);
  }

  @Override
  public Cat setCatToStaticMemory(int index, Cat cat) {
    return CatDatabase.setCat(index, cat);
  }

  @Override
  public Cat createCatToStaticMemory(int index, Cat cat) {
    return CatDatabase.createCat(index, cat);
  }

  @Override
  public Boolean deleteCatFromStaticMemory(int index) {
    
    Cat deletedCat = CatDatabase.deleteCat(index);

    if (deletedCat == null) {
      return false;
    }

    return true;
  } 

  @Override
  public Cat putCatToStaticMemory(int index, Cat cat) {
    return CatDatabase.updateCat(index, cat);
  } 

  @Override
  public Cat patchCatToStaticMemory(int index, String name) {
    return CatDatabase.patchCat(index, name);
  } 

  @Override
  public Cat patchCatToStaticMemory(int index, int age) {
    return CatDatabase.patchCat(index, age);
  } 

  @Override
  public List<Cat> getCats() {
    return Arrays.stream(CatDatabase.getCats()).collect(Collectors.toList());    
  }
}
