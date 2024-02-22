package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.Objects;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bootcampsbforum.model.User2;

public class RedisHelper {

  private RedisTemplate<String, String> redisTemplate;
  private ObjectMapper objectMapper;

  public RedisHelper(RedisConnectionFactory factory, ObjectMapper objectMapper) {
    Objects.requireNonNull(objectMapper);

    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();

    redisTemplate.setConnectionFactory(factory);
    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(RedisSerializer.json());
    redisTemplate.afterPropertiesSet();
    this.redisTemplate = redisTemplate;
    this.objectMapper = objectMapper;
  }

  public RedisHelper(RedisTemplate<String, String> redisTemplate, ObjectMapper objectMapper) {
    Objects.requireNonNull(redisTemplate);
    Objects.requireNonNull(objectMapper);
    this.redisTemplate = redisTemplate;
    this.objectMapper = objectMapper;
  }

  public void set(String key, Object value) throws JsonProcessingException {
    
    String serializedData = objectMapper.writeValueAsString(value);

    this.redisTemplate.opsForValue().set(key, serializedData);
    
  }

  public <T> T get(String key, Class<T> clazz) throws JsonProcessingException {

    String value = this.redisTemplate.opsForValue().get(key);
    return objectMapper.readValue(value, clazz);

  }


}
