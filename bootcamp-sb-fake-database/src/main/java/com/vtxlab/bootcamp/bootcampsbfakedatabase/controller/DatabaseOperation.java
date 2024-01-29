package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public interface DatabaseOperation {

  // 2 ways to define variable from the URI
  // 1. PathVariable /{variable}
  @GetMapping(value = "/cat/{idx}")
  Cat getCat(@PathVariable(name = "idx") int index);

  @GetMapping(value = "/cat/index/{index}/name/{name}/age/{age}")
  void setCat(@PathVariable int index, //
      @PathVariable String name, //
      @PathVariable int age);

}
