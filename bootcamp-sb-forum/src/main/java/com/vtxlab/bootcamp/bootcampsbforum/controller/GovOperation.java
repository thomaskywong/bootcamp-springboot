package com.vtxlab.bootcamp.bootcampsbforum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;

public interface GovOperation {

  // 1. no user found
  // 2. user found, not no post
  @GetMapping(value = "/users")
  @ResponseStatus(value = HttpStatus.OK) // Use Global Exception Handler to catch exceptions 
  ApiResponse<UserPostDTO> getUsers(@RequestParam int userId);



  // 404 -> request path issue orresource not found
  // 204 -> id not found.


  // NPE
  @GetMapping(value = "/test/npe")
  public String testNPE();

  @GetMapping(value = "/test/modelmapper")
  UserDTO testModelMapper();

}
