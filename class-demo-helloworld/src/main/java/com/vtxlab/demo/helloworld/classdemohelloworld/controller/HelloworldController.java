package com.vtxlab.demo.helloworld.classdemohelloworld.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vtxlab.demo.helloworld.classdemohelloworld.model.Cat;

@Controller // Web layer, provide the capability of API
@ResponseBody // JSON
@RequestMapping(value = "/api/v1")
public class HelloworldController {

  // in normal class
  // attributes, consturctor(s), instance methods

  // In spring boot, as a worker
  // NO attributes, NO consturctor, HAVE instance methods

  @GetMapping(value = "/hello") // provide location in server
  @ResponseBody // JSON (format of data transmission - System A call System B API)
  public String helloworld() {
    return "Welcome to Spring Boot.";
  }

  // One more API
  // return primitive? wrapper class?

  @GetMapping(value = "/wrapper")
  @ResponseBody
  public Integer wrapper() {
    return 1000;
  }

  // JASON has no Character class. Convert to String automatically
  @GetMapping(value = "/character")
  @ResponseBody
  public Character character() {
    return 'D';
  }

  @GetMapping(value = "/primitive")
  @ResponseBody
  public double primitive() {
    return 3.1415;
  }

  // return Cat
  @GetMapping(value = "/cat")
  @ResponseBody
  public Cat classObject() {
    // return new Cat("Thomas", 0);
    return Cat.builder() //
        .name("Tommy") //
        .age(44) //
        .build();
  }

  // return List<Cat>
  @GetMapping(value = "/listofcat")
  @ResponseBody
  public List<Cat> listOfObject() {
    return new ArrayList<Cat>(
        List.of(new Cat("Thomas", 0), new Cat("Emily", 1), new Cat("Joe", 2)));
  }

  // return Stream<Cat>
  @GetMapping(value = "/streamofcat")
  @ResponseBody
  public Stream<Cat> streamOfObject() {
    return Stream.of(new Cat("Thomas", 0), new Cat("Emily", 1),
        new Cat("Joe", 2), new Cat("Tom", 3));
  }

  // return Stream
  @GetMapping(value = "/listofcat2")
  @ResponseBody
  public List<Cat> listOfObject2() {
    return Stream
        .of(new Cat("Thomas", 0), new Cat("Emily", 1), new Cat("Joe", 2),
            new Cat("Tom", 3), new Cat("Jerry", 5))
        .collect(Collectors.toList());
  }

  // return Cat[]
  @GetMapping(value = "/arrayofcat")
  @ResponseBody
  public Cat[] arrayOfObject() {
    return new Cat[] {new Cat("Thomas", 0), //
        new Cat("Emily", 1), //
        new Cat("Joe", 2), //
        new Cat("Tom", 3), //
        new Cat("Jerry", 5), //
        new Cat("Gordon", 13)};
  }

}
