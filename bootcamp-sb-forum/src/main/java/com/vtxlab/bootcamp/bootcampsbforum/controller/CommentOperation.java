package com.vtxlab.bootcamp.bootcampsbforum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;

public interface CommentOperation {
  // HomeWorks
  // 1. no user found
  // 2. user found, but no comment
  // @GetMapping(value = "/comments")
  // @ResponseStatus(value = HttpStatus.OK)
  UserCommentDTO getUserComments(@RequestParam Long userId);
  
}
