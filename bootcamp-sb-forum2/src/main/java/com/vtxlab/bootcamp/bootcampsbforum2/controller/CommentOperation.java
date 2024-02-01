package com.vtxlab.bootcamp.bootcampsbforum2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.vtxlab.bootcamp.bootcampsbforum2.model.dto.jdh.Comment;

public interface CommentOperation {

  @GetMapping(value = "/comments")
  List<Comment> getComments();
  
}
