package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserService {

  List<User> getUsers();

  User getUser(Integer id);

//   Long countUserByName(String prefix);

//   UserEntity findById(Long id);

  // List<UserEntity> findAllByAddrLatGreaterThan(Integer latitutde);

  List<UserEntity> findAll(List<Post> posts);


//   List<UserEntity> findAllByAddr(
//       Double Latitude);

//   List<UserEntity> findAllByEmailAndPhoneDesc(
//       String email, String phone);

//   List<UserEntity> findAllByEmailOrPhoneDesc(
//       String email, String phone);

//   void updateUserEmail(Long id, String email);

//   UserEntity updateUserById(Long id, UserEntity user);


}
