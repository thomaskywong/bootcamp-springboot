package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.PostEntity;
import com.vtxlab.bootcamp.bootcampsbforum.mapper.PostMapper;
import com.vtxlab.bootcamp.bootcampsbforum.model.Post2;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.repository.PostRepository;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostDatabaseService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class PostDatabaseHolder implements PostDatabaseService {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private PostMapper postMapper;

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<PostEntity> saveAll(List<PostEntity> posts) {
    postRepository.saveAll(posts);
    return postRepository.findAll();
  }

  @Override
  public void deleteAllPosts() {
    postRepository.deleteAll();
  }

  @Override
  public List<PostEntity> findAll() {
    return postRepository.findAll();
  }

  // @Override
  // public PostEntity updateDBPostById(Long id, PostEntity newPostEntity){
  //   PostEntity postEntity = entityManager.find(PostEntity.class, id);

  //   postEntity.setUserId(newPostEntity.getUserId()); 
  //   postEntity.setTitle(newPostEntity.getTitle()); 
  //   postEntity.setBody(newPostEntity.getBody());

  //   entityManager.merge(postEntity);

  //   return entityManager.find(PostEntity.class, id);
  // }

  // @Override
  // @Transactional // annotation for entityManager 
  // public Post2 updateDBPostById(Long id, Post2 newPost){

  //   PostEntity newPostEntity = postMapper.mapToEntity(newPost);
  //   System.out.println("new post=" + newPostEntity);

  //   PostEntity postEntity = entityManager.find(PostEntity.class, id);
  //   System.out.println("post from DB=" +postEntity);


  //   postEntity.setUserId(newPostEntity.getUserId()); 
  //   postEntity.setTitle(newPostEntity.getTitle()); 
  //   postEntity.setBody(newPostEntity.getBody());

  //   System.out.println("updated post=" +postEntity);

  //   entityManager.merge(postEntity);

  //   PostEntity updatedPostEntity = entityManager.find(PostEntity.class, id);

  //   Post2 updatedPost = postMapper.mapToPost2(updatedPostEntity);

  //   return updatedPost;
  //   // return newPost;
  // }

  // @Override
  // public List<Post> getDBPostsById(Long id) {
    
  //   List<PostEntity> postsEntityDB = postRepository.findAllByUserId(id);

  //   return postsEntityDB.stream().map(e -> postMapper.mapToPost(e)).collect(Collectors.toList());

  // }

  // @Override
  // public List<Post> getDBPostsByIdJPQL(Long id) {
    
  //   List<PostEntity> postEntities = postRepository.getDBPostByIdJPQL(id);

  //   List<Post> postList = postEntities.stream() //
  //                                     .map( e -> postMapper.mapToPost(e)) //
  //                                     .collect(Collectors.toList());
  //   return postList;

  // }

  // @Override
  // @Transactional // annotation for entityManager 
  // public Post2 setPostByPostId(Long id, Post2 newPost) {
    
  //   postRepository.setPostUserIdByPostId(newPost.getUserId(), id);
  //   postRepository.setPostTitleByPostId(newPost.getTitle(), id);
  //   postRepository.setPostBodyByPostId(newPost.getBody(), id);

  //   PostEntity postEntity = entityManager.find(PostEntity.class, id);

  //   return postMapper.mapToPost2(postEntity);
  // }


  // @Override
  // public List<Post2> getPostByIdSQL(Long id) {
  //   List<PostEntity> postEntities = postRepository.getPostByIdSQL(id);
  //   return postEntities.stream() //
  //                      .map(e -> postMapper.mapToPost2(e)) //
  //                      .collect(Collectors.toList());
  // }
  
  
}
