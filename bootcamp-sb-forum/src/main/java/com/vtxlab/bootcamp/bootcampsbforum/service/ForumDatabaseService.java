package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;


// interface to Database
public interface ForumDatabaseService {

  List<UserEntity> saveUsers(List<UserEntity> users);

  UserEntity saveUser(UserEntity user);

  void deleteAllUsers();

  
  
}
