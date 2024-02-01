package com.vtxlab.bootcamp.bootcampsbforum2.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vtxlab.bootcamp.bootcampsbforum2.controller.CommentOperation;
import com.vtxlab.bootcamp.bootcampsbforum2.model.dto.jdh.Comment;
import com.vtxlab.bootcamp.bootcampsbforum2.service.CommentService;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v1")
public class CommentController implements CommentOperation {

  @Autowired
  private CommentService commentService;


  @Override
  public List<Comment> getComments() {
    System.out.println("Start Controller.");
    return commentService.getComments();
  }


  
}
