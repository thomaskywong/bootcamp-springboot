package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserService {

  List<User> getUsers();

  User getUser(Long id);

  Long countUserByName(String prefix);

  com.vtxlab.bootcamp.bootcampsbforum.entity.User findById(Long id);

  // List<User> findAllByAddrLatGreaterThan(Integer latitutde);
  List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> findAll();


  List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> findAllByAddr(
      Double Latitude);

  List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> findAllByEmailAndPhoneDesc(
      String email, String phone);

  List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> findAllByEmailOrPhoneDesc(
      String email, String phone);

  void updateUserEmail(Long id, String email);

  com.vtxlab.bootcamp.bootcampsbforum.entity.User updateUserById(Long id,
      com.vtxlab.bootcamp.bootcampsbforum.entity.User user);


}
