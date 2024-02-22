package com.vtxlab.bootcamp.bootcampsbforum.polymorphism;

public class Cat implements Flyable, Swimmable {

  @Override
  public void swim() {

  }

  @Override
  public void fly() {

  }


  public static void main(String[] args) {
    
    Cat cat = new Cat();

    Swimmable swimmableCat = cat;
    Flyable flyableCat = cat;

    swimmableCat.swim();
    flyableCat.fly();
    
    cat.swim();
    cat.fly();


  }
  
}
