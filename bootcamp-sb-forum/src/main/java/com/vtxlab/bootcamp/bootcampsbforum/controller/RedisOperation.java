package com.vtxlab.bootcamp.bootcampsbforum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbforum.model.User2;

public interface RedisOperation {

  @PostMapping(value = "/user2")
  @ResponseStatus(value = HttpStatus.OK)
  User2 setUser2(@RequestParam String key, @RequestBody User2 value) throws JsonProcessingException;

  @GetMapping(value = "/user2")
  @ResponseStatus(value = HttpStatus.OK)
  User2 getUser2(@RequestParam String key) throws JsonProcessingException;
  
}
