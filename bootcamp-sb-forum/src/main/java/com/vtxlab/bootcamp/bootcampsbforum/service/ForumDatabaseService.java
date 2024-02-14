package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.entity.User;

// interface to Database
public interface ForumDatabaseService {

  List<User> saveUsers(List<User> users);

  User saveUser(User user);

  void deleteAllUsers();
  
}
