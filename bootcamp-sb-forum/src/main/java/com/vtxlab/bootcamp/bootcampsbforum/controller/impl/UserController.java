package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.UserOperation;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController implements UserOperation{
  
  // Dependency injection (@Service)
  @Autowired
  private UserService userService;


  @Override
  public List<User> getUsers() {

    // System.out.println("start controller");

    return userService.getUsers();

  }

  // @Override
  // public String hello(){
  //   return "Hello";
  // }

  // @Override
  // public List<Post> getPosts() {
  //   return userService.getPosts();
  // }

  // @Override
  // public List<Comment> getComments() {
  //   return userService.getComments();
  // }
  
}
