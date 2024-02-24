package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.PostOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;

@RestController
@RequestMapping(value = "/api/v1")
public class PostController implements PostOperation {

  @Autowired
  private PostService postService;

  // @Autowired
  // private PostDatabaseService postDatabaseService;

  // @Autowired
  // private PostMapper postMapper;

  // @Autowired
  // private UserService userService;

  @Override
  public List<Post> getPosts() {
    return postService.getPosts();
  }

  @Override
  public UserPostDTO getPost(Long id) {
    return postService.getPost(id);
  }

  // @Override
  // public Post2 updateDBPostById(Long id, Post2 post) {

  //   return postDatabaseService.updateDBPostById(id, post);
  //   // return post;

  // }

  // @Override
  // public UserPostDTO getDBPostById(Long id) {

  //   User user = userService.getUser(id);

  //   List<Post> posts = postDatabaseService.getDBPostsById(id);

  //   // System.out.println(posts);
  //   UserPostDTO posts1 = postMapper.map(user, posts);

  //   // System.out.println(posts1);

  //   // return postMapper.map(user, posts);
  //   return posts1;

  // }

  // @Override
  // public UserPostDTO getDBPostByIdJPQL(Long id) {

  //   User user = userService.getUser(id);

  //   List<Post> posts = postDatabaseService.getDBPostsByIdJPQL(id);

  //   UserPostDTO posts1 = postMapper.map(user, posts);

  //   return posts1;

  // }

  // @Override
  // public Post2 updateDBPostByIdJPQL(Long id, Post2 newPost) {

  //   return postDatabaseService.setPostByPostId(id, newPost);
  // }

  // @Override
  // public List<Post2> getPostByIdSQL(Long id) {
  //   return postDatabaseService.getPostByIdSQL(id);
  // }
  


}


