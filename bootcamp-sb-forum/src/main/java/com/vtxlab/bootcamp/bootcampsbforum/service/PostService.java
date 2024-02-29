package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;

public interface PostService {

  List<Post> getPosts();

  UserPostDTO getPost(Integer id);

  List<Post> getPostsFromDB();

}
