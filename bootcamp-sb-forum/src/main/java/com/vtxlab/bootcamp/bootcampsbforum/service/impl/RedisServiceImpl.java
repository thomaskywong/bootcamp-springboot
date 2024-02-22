package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbforum.controller.impl.RedisHelper;
import com.vtxlab.bootcamp.bootcampsbforum.model.User2;
import com.vtxlab.bootcamp.bootcampsbforum.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService {

  @Autowired
  private RedisHelper redisHelper;

  @Override
  public User2 setUser2(String key, User2 user) throws JsonProcessingException{
    
    redisHelper.set(key, user);
    return redisHelper.get(key, User2.class);
  }

  @Override
  public User2 getUser2(String key) throws JsonProcessingException {
    return redisHelper.get(key, User2.class);
  }
  
}
