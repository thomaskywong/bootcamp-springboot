package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.mapper.UserMapper;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.ForumDatabaseService;
import com.vtxlab.bootcamp.bootcampsbforum.service.GovService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@Service
public class GovServiceHolder implements GovService {


  @Autowired
  private UserService userService;

  @Autowired
  private UserMapper govMapper;

  @Autowired
  private ForumDatabaseService forumDatabaseService;


  @Override
  public User getUser(Integer id) {
    User user = userService.getUser(id);

    if (user != null) {
      forumDatabaseService.saveUser(govMapper.mapEntity(user));
    }

    return user;

  }

  // step 1. call JPH, object Users from JPH
  // step 2. delete existing database
  @Override
  public List<User> getUsers() {

    // call JPH. get users from jph
    // throws exception if ResourcesNotFound!
    List<User> users = userService.getUsers();

    // clear user database
    forumDatabaseService.deleteAllUsers();

    // save all
    List<UserEntity> userEntities =
        users.stream() //
            .map(e -> govMapper.mapEntity(e)) //
            .collect(Collectors.toList());

    forumDatabaseService.saveUsers(userEntities);

    return users;
  }



}


