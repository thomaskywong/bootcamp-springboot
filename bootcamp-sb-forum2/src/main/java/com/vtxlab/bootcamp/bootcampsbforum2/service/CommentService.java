package com.vtxlab.bootcamp.bootcampsbforum2.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum2.model.dto.jdh.Comment;

public interface CommentService {

  List<Comment> getComments();
  
}
