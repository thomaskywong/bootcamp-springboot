package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;

public interface CommentService {

  List<Comment> getComments();
  
}
