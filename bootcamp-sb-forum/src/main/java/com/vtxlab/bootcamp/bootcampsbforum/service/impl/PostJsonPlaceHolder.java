package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.BcUtil;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.mapper.PostMapper;
import com.vtxlab.bootcamp.bootcampsbforum.mapper.UserMapper;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostDatabaseService;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;
import com.vtxlab.bootcamp.bootcampsbforum.entity.PostEntity;

@Service
public class PostJsonPlaceHolder implements PostService {

  @Value(value = "${api.jph.domain}")
  private String domain;

  @Value(value = "${api.jph.endpoints.post}")
  private String postEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserService userService;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private PostMapper postMapper;

  @Autowired
  private PostDatabaseService postDatabaseService;
  // @PersistenceContext
  // private EntityManager entityManager;

  @Override
  public List<Post> getPostsFromDB() {
    System.out.println("PostJsonPlaceHolder.");
    List<PostEntity> postEntites = postDatabaseService.findAll();
    return postEntites.stream().map(e -> postMapper.mapToPost(e)).collect(Collectors.toList());
  }

  @Override
  public List<Post> getPosts() {

    String urlString = BcUtil.url(Scheme.HTTPS, domain, postEndpoint);

    Post[] posts = restTemplate.getForObject(urlString, Post[].class);

    return  Arrays.stream(posts).collect(Collectors.toList());
    

    // try {
    //   Post[] posts = restTemplate.getForObject(urlString, Post[].class);

    //   List<PostEntity> postEntities = Arrays.stream(posts) //
    //                                         .map(e -> postMapper.mapToEntity(e)) //
    //                                         .collect(Collectors.toList());
      
    //   postDatabaseService.deleteAllPosts();
    //   postDatabaseService.saveAll(postEntities);
    //   List<PostEntity> postEntitiesFromDB = postDatabaseService.findAll();

    //   List<Post> postList = postEntitiesFromDB.stream() //
    //                                           .map( e -> postMapper.mapToPost(e)) //
    //                                           .collect(Collectors.toList());

    //   return postList;

    // } catch (RestClientException ex) {
    //   throw new JPHClientException(Syscode.JPH_NOT_AVAILABLE);
    // }
  }

  @Override
  public UserPostDTO getPost(Long id) {

    User user = userService.getUser(id);

    String urlString = BcUtil.url(Scheme.HTTPS, domain, postEndpoint);

    Post[] posts = restTemplate.getForObject(urlString, Post[].class);
    List<Post> postList =  Arrays.stream(posts) //
                                 .collect(Collectors.toList());

    return userMapper.map(user, postList);

    // try {
    //   Post[] posts = restTemplate.getForObject(urlString, Post[].class);
    //   List<Post> postList =  Arrays.stream(posts).collect(Collectors.toList());
      
    //   List<PostEntity> postEntityList = postList.stream() //
    //                                             .map( e -> postMapper.mapToEntity(e)) //
    //                                             .collect(Collectors.toList());
    //   postDatabaseService.saveAll(postEntityList);
    //   List<PostEntity> postEntityListDB = postDatabaseService.findAll();
    //   List<Post> postListDB = postEntityListDB.stream() //
    //                                           .map( e -> postMapper.mapToPost(e)) //
    //                                           .collect(Collectors.toList());
      
    //   return postMapper.map(user, postListDB);

    // } catch (RestClientException ex) {
    //   throw new JPHClientException(Syscode.JPH_NOT_AVAILABLE);
    // }

  }

}


