package com.vtxlab.bootcamp.bootcampsbforum.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.mapper.RequestDTOMapper;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.repository.UserRepository;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

// implicitly
// @Autowired (required = false)
// private CommandLineRunner commandLineRunner
// main code -> if (commandLineRunner != null) commandLineRunner.run();
// Service Starts, run Application Runner
// AppRunner prepare everything ready before server starts

// Main Tasks in AppRunner:
// 1. Checking on configuration - DB or yml
// 2. Invoke API to get data (ie. configuration, raw data)
// if not ready, throws exception and terminate server
// Guarantee things are ready before Server starts

@Component
public class AppRunner implements CommandLineRunner {

  // @Value(value = "${api.jph.domain}")
  // private String domain;

  // @Value(value = "${api.jph.endpoints.user}")
  // private String userEndpoint;

  // @Autowired
  // private ForumDatabaseService forumDatabaseService;

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private RequestDTOMapper requestDTOMapper;

  @Autowired
  private UserRepository userRepository;

  // @Autowired
  // private UserMapper govMapper;

  @Override
  public void run(String... args) throws Exception {


    // Extract data from JPH
    List<User> users = userService.getUsers();
    List<Post> posts = postService.getPosts();

    // Prepare Data for Serializable
    List<UserEntity> userEntities = new ArrayList<>();

    for (User user : users) {

      // Prepare UserEntity
      UserEntity userEntity = requestDTOMapper.mapToUserEntity(user, posts);

      userEntities.add(userEntity);

    }

    userRepository.saveAll(userEntities);
    System.out.println("Update Time:" + LocalDateTime.now());
    // Call JPH -> User and Posts -> put it to database
    // could not call JPH -> RestClientException -> throw exception

    // List<User> users = userService.getUsers();

    // Objects.requireNonNull(users);

    // forumDatabaseService.deleteAllUsers();

    // List<UserEntity> userEntities =
    // users.stream() //
    // .map(e -> govMapper.mapEntity(e)) //
    // .collect(Collectors.toList());

    // forumDatabaseService.saveUsers(userEntities);

  }
}
