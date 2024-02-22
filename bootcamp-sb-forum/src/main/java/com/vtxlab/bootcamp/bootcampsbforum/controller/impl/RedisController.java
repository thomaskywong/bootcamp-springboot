package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbforum.controller.RedisOperation;
import com.vtxlab.bootcamp.bootcampsbforum.model.User2;
import com.vtxlab.bootcamp.bootcampsbforum.service.RedisService;

@RestController
@RequestMapping(value = "/redis/api/v1")
public class RedisController implements RedisOperation {

  @Autowired
  private RedisService redisService;

  @Override
  public User2 setUser2(String key, User2 value) throws JsonProcessingException {
    return redisService.setUser2(key, value);
  }

  @Override
  public User2 getUser2(String key) throws JsonProcessingException {
    return redisService.getUser2(key);
  }

  
}
