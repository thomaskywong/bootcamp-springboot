package com.vtxlab.bootcamp.bootcampsbforum3.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.vtxlab.bootcamp.bootcampsbforum3.model.dto.jph.Post;

public interface PostOperation {

  @GetMapping(value = "/posts")
  List<Post> getPosts();
  
}
