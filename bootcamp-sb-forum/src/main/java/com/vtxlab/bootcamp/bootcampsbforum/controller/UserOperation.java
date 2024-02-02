package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserOperation {

  @GetMapping(value ="/users")
  List<User> getUsers();

  // Test connection. Call hello from postmen
  // @GetMapping(value = "/hello")
  // String hello();

  // @GetMapping(value ="/posts")
  // List<Post> getPosts();

  // @GetMapping(value ="/comments")
  // List<Comment> getComments();

  
}
