package com.vtxlab.bootcamp.bootcampsbfakedatabase.database;


import java.util.Objects;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public class CatDatabase {

  private static Cat[] cats;

  private static final int dbLength = 10;

  static {
    CatDatabase.cats = new Cat[dbLength];
    cats[0] = new Cat("John", 2);
    cats[1] = new Cat("Mary", 1);
  }

  public static Cat getCat(int index) {

    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException();

    return cats[index];
  }

  public static void setCat(int index, String name, int age) {

    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException();
      
    Objects.requireNonNull(name);

    cats[index] = new Cat(name, age);
  }
  
}
