package com.vtxlab.bootcamp.bootcampsbfakedatabase.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public interface CatDatabaseService {
  
  Cat getCatFromStaticMemory(int index);

  Cat setCatToStaticMemory(int index, Cat cat);

  Cat createCatToStaticMemory(int index, Cat cat);

  Boolean deleteCatFromStaticMemory(int index);

  Cat putCatToStaticMemory(int index, Cat cat);

  Cat patchCatToStaticMemory(int index, String name);

  Cat patchCatToStaticMemory(int index, int age);

  List<Cat> getCats();
 
  
}
