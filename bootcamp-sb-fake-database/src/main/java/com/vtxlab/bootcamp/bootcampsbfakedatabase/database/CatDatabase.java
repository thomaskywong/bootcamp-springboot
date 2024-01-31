package com.vtxlab.bootcamp.bootcampsbfakedatabase.database;


import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public class CatDatabase {

  private static Cat[] cats;

  private static final int dbLength = 10;

  static {
    cats = new Cat[dbLength];
    cats[0] = new Cat("John", 2);
    cats[1] = new Cat("Mary", 1);
  }

  public static synchronized Cat getCat(int index) {
    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException();
    return cats[index];
  }

  public static synchronized Cat setCat(int index, Cat cat) {
    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException();
    cats[index] = cat;

    return cat;
  }

  public static synchronized Cat createCat(int index, Cat cat) {
    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException();
    
    Cat cat2 = getCat(index);
    if (cat2 != null) {
      return cat2;
    } 
    cat2 = setCat(index,cat);
    return cat2;
  }

  public static synchronized Cat deleteCat(int index) {
    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException();
    
    Cat deletedCat =  cats[index];

    setCat(index, null);

    return deletedCat;
  }

  public static synchronized Cat updateCat(int index, Cat cat) {
    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException();
    
    // Cat deletedCat =  cats[index];

    setCat(index, cat);

    return getCat(index);
  }

  public static synchronized Cat patchCat(int index, String name) {
    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException();
    
    Cat cat = getCat(index);
    
    if (cat == null) 
      throw new IllegalArgumentException();

    cat.setName(name);

    return getCat(index);
  }

  public static synchronized Cat patchCat(int index, int age) {
    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException();
    
    Cat cat2 = getCat(index);

    if (cat2 == null) 
      throw new IllegalArgumentException();

    cat2.setAge(age);

    return getCat(index);
  }

  public static Cat[] getCats() {
    return cats;
  }
  
}
