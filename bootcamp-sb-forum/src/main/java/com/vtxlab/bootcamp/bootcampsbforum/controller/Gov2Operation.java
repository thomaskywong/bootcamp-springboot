package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bootcampsbforum.annotation.UserIdChecker;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.request.UserIdRQDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResp;

@Validated
public interface Gov2Operation {

  // 1. no user found
  // 2. user found, not no post
  @GetMapping(value = "/user")
  @ResponseStatus(value = HttpStatus.OK) // Use Global Exception Handler to catch exceptions
  ApiResp<UserPostDTO> getUser(@UserIdChecker @RequestParam(value = "id") UserIdRQDTO userId);

  // @GetMapping(value = "/users")
  // @ResponseStatus(value = HttpStatus.OK)
  ApiResp<List<UserPostDTO>> getUsers();

  // @GetMapping(value = "/comments")
  UserCommentDTO getUserComments(@RequestParam Integer userId);

  // 404 -> request path issue orresource not found
  // 204 -> id not found.

  // NPE
  // @GetMapping(value = "/test/npe")
  public String testNPE();

  // @GetMapping(value = "/test/modelmapper")
  UserDTO testModelMapper();

}

