package com.vtxlab.bootcamp.bootcampsbforum2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.bootcampsbforum2.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum2.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbforum2.infra.ResourceNotFound;

public interface CommentOperation {

  // @GetMapping(value = "/comments")
  // List<Comment> getComments();

    // HomeWorks
  // 1. no user found
  // 2. user found, but no comment
  @GetMapping(value = "/comments")
  ResponseEntity<ApiResp<UserCommentDTO>> getUserComments(@RequestParam int userId) throws ResourceNotFound;
  
}
