package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.repository.UserRepository;
import com.vtxlab.bootcamp.bootcampsbforum.service.ForumDatabaseService;

@Service
public class ForumDatabaseHolder implements ForumDatabaseService {

  // Get UserRepository Bean that implements JpaRepository for methods to database (SQL)
  @Autowired
  private UserRepository userRepository;

  @Override
  public List<UserEntity> saveUsers(List<UserEntity> users) {

    return userRepository.saveAll(users);
  }

  // User in Entity format. (.entity.User)
  @Override
  public UserEntity saveUser(UserEntity user) {

    // UserRepository.save() saves element in database, and return the saved element
    return userRepository.save(user);
  }

  @Override
  public void deleteAllUsers() {

    userRepository.deleteAll();
  }

}
