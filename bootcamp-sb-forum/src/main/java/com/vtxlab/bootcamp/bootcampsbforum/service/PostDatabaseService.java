package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.entity.PostEntity;
import com.vtxlab.bootcamp.bootcampsbforum.model.Post2;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;

public interface PostDatabaseService {

  List<PostEntity> saveAll(List<PostEntity> posts);

  void deleteAllPosts();

  List<PostEntity> findAll();

  // PostEntity updateDBPostById(Long id, PostEntity newPostEntity);

  // Post2 updateDBPostById(Long id, Post2 newPost);

  // List<Post> getDBPostsById(Long id);

  // List<Post> getDBPostsByIdJPQL(Long id);

  // Post2 setPostByPostId(Long id, Post2 newPost);

  // List<Post2> getPostByIdSQL(Long id);

  

  
}
