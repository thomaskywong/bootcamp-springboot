package com.vtxlab.bootcamp.bootcampsbforum2.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum2.controller.CommentOperator;
import com.vtxlab.bootcamp.bootcampsbforum2.model.dto.jdh.Comment;
import com.vtxlab.bootcamp.bootcampsbforum2.service.CommentService;

@RestController
@RequestMapping(value = "/api/v1")
public class CommentController implements CommentOperator {

  @Autowired
  private CommentService commentService; 


  @Override
  public List<Comment> getComments() {
    System.out.println("Start Controller.");
    return commentService.getComments();
    // return new CommentServiceImpl().getComments();
  }


  
}
