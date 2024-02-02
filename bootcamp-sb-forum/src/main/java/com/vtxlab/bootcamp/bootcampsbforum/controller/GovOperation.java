package com.vtxlab.bootcamp.bootcampsbforum.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ResourceNotFound;

public interface GovOperation {

  // 1. no user found
  // 2. user found, not no post
  @GetMapping(value = "/users")
  ResponseEntity<ApiResp<UserPostDTO>> getUsers(@RequestParam int userId) throws ResourceNotFound;

  // HomeWorks
  // 1. no user found
  // 2. user found, but no comment
  @GetMapping(value = "/comments")
  UserCommentDTO getUserComments(@RequestParam int userId);

  // 404 -> request path issue orresource not found
  // 204 -> id not found.

}
