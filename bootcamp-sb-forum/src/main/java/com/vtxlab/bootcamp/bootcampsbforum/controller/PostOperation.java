package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.model.Post2;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;

public interface PostOperation {

  @GetMapping(value = "/posts")
  @ResponseStatus(value = HttpStatus.OK)
  List<Post> getPosts();

  @GetMapping(value = "/post")
  @ResponseStatus(value = HttpStatus.OK)
  UserPostDTO getPost(@RequestParam Long id);

  // @PostMapping(value = "/database/post")
  // @ResponseStatus(value = HttpStatus.OK)
  // Post2 updateDBPostById(@RequestParam Long id, @RequestBody Post2 post);

  // @GetMapping(value = "/database/post")
  // @ResponseStatus(value = HttpStatus.OK)
  // UserPostDTO getDBPostById(@RequestParam Long id);

  // @GetMapping(value = "/database/postJPQL")
  // @ResponseStatus(value = HttpStatus.OK)
  // UserPostDTO getDBPostByIdJPQL(@RequestParam Long id);

  // @PostMapping(value = "/database/postJPQL")
  // @ResponseStatus(value = HttpStatus.OK)
  // Post2 updateDBPostByIdJPQL(@RequestParam Long id, @RequestBody Post2 post);

  // @GetMapping(value = "/database/postSQL")
  // @ResponseStatus(value = HttpStatus.OK)
  // List<Post2> getPostByIdSQL(@RequestParam Long id);

  
}
