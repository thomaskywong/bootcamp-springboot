package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public interface DatabaseOperation {

  // 2 ways to define variable from the URI
  // 1. PathVariable /{variable}
  @GetMapping(value = "/cat/{idx}")
  Cat getCat(@PathVariable(name = "idx") int index);

  // just practice only Use PostMapping
  @GetMapping(value = "/cat/index/{index}/name/{name}/age/{age}")
  void setCat(@PathVariable int index, //
      @PathVariable String name, //
      @PathVariable int age);

  // @PostMapping(value = "/cat/{idx}")
  // Use PostMapping to set cat
  // Use @RequestBody to accept the JSON input of Cat
  @PostMapping(value = "/cat/{idx}")
  Cat createCat(@PathVariable int idx, @RequestBody Cat cat);


  // @DeleteMapping
  // use DeleteMapping to delete cat
  @DeleteMapping(value = "/cat/{idx}")
  Boolean deleteCat(@PathVariable int idx);

  // @PutMapping(value = "/cat/{idx}")
  // use to replace the whole object in database
  // Use @RequestBody to accept the JSON input of Cat
  @PutMapping(value = "/cat/{idx}")
  Cat putCat(@PathVariable int idx, @RequestBody Cat cat);

  // @PatchMapping(value = "/cat/{idx}/name/{name}")
  // use to replace some attribute of an object in database
  @PatchMapping(value = "/cat/{idx}/name/{name}")
  Cat patchCat(@PathVariable int idx, @PathVariable String name);

  @PatchMapping(value = "/cat/{idx}/age/{age}")
  Cat patchCat(@PathVariable int idx, @PathVariable int age);

  // Get All
  @GetMapping(value = "/cats")
  List<Cat> getCats();

  // getCat2 using @RequestParam
  @GetMapping(value = "/cat")
  Cat getCat2(@RequestParam(name = "idx") int index);

}
