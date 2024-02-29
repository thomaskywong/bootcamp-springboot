package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.DataOperation;
import com.vtxlab.bootcamp.bootcampsbforum.controller.UserOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbforum.mapper.UserMapper;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController implements UserOperation, DataOperation {

  // Dependency injection (@Service)
  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private UserMapper userMapper;

  @Override 
  public User getUser(Integer id) {
    return userService.getUser(id);
  }

  @Override
  public List<User> getUsers() {
    // System.out.println("start controller");
    return userService.getUsers();
  }


  @Override
  public List<UserEntity> getUserEntities() {
    // System.out.println("start controller");

    List<Post> posts = postService.getPosts();
    return userService.findAll(posts);
  }

  @Override
  public ApiResp<UserDTO> userInfo(Integer id) {
    User user = userService.getUser(id);
    UserDTO dto = userMapper.map(user);
    return ApiResp.<UserDTO>builder() //
                  .ok() //
                  .data(dto) //
                  .build();
  }

  // @Override
  // public UserEntity getUser2(Long id) {
  //   // System.out.println("start controller");
  //   return userService.findById(id);
  // }


  // @Override
  // public List<UserEntity> findAllByAddr(
  //     Double Latitude) {
  //   return userService.findAllByAddr(Latitude);
  // }

  // @Override
  // public List<UserEntity> findAllByEmailOrPhone(
  //     String email, String phone) {
  //   return userService.findAllByEmailOrPhoneDesc(email, phone);
  // }

  // @Override
  // public Long countUserByName(String prefix) {
  //   return userService.countUserByName(prefix.toLowerCase());
  // }

  // @Override
  // public void patchUserEmailById(long id, String email) {
  //   userService.updateUserEmail(id, email);
  // }

  // @Override
  // public UserEntity putUserById(long id,
  //     UserEntity newUser) {

  //   return userService.updateUserById(id, newUser);
  // }

}
