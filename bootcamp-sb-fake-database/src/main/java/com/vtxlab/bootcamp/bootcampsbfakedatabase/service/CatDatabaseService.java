package com.vtxlab.bootcamp.bootcampsbfakedatabase.service;

import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public interface CatDatabaseService {
  
 Cat getCatFromStaticMemory(int index);

 void setCattoStaticMemory(int index, String name, int age);
 
  
}
