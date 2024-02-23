package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserOperation {

  // Test connection. Call hello from postmen
  // @GetMapping(value = "/hello")
  // String hello();

  // @GetMapping(value ="/posts")
  // List<Post> getPosts();

  // @GetMapping(value ="/comments")
  // List<Comment> getComments();

  // @GetMapping(value = "/repository")
  // List<User> findAllByAddrLatGreaterThan(@Param("lat") Integer latitutde);

  @GetMapping(value = "/user")
  @ResponseStatus(value = HttpStatus.OK)
  User getUser(@RequestParam Long id);

  @GetMapping(value = "/users")
  @ResponseStatus(value = HttpStatus.OK)
  List<User> getUsers();

  @GetMapping(value = "/database/users")
  @ResponseStatus(value = HttpStatus.OK)
  List<UserEntity> getUsers2();

//   @GetMapping(value = "/database/user")
//   @ResponseStatus(value = HttpStatus.OK)
//   UserEntity getUser2(
//       @RequestParam Long id);

//   @GetMapping(value = "/users/count")
//   Long countUserByName(@RequestParam(value = "prefix") String prefix);

//   @GetMapping(value = "/users/addrlat")
//   @ResponseStatus(value = HttpStatus.OK)
//   List<UserEntity> findAllByAddr(
//       @RequestParam(value = "lat") Double Latitude);

//   @GetMapping(value = "/users/email/{email}/phone/{phone}")
//   @ResponseStatus(value = HttpStatus.OK)
//   List<UserEntity> findAllByEmailOrPhone(
//       @PathVariable String email, @PathVariable String phone);


//   @PatchMapping(value = "/users/id/{id}/email/{email}")
//   @ResponseStatus(value = HttpStatus.OK)
//   void patchUserEmailById(@PathVariable long id, @PathVariable String email);

//   @PutMapping(value = "/users/id/{id}")
//   @ResponseStatus(value = HttpStatus.OK)
//   UserEntity putUserById(
//       @PathVariable long id,
//       @RequestBody UserEntity newUser);


}
