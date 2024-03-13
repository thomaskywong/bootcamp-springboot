package com.vtxlab.bootcamp.bootcampsbforum.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.mapper.RequestDTOMapper;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.repository.UserRepository;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@Component
@EnableScheduling
public class ScheduledConfig {

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private RequestDTOMapper requestDTOMapper;

  @Autowired
  private UserRepository userRepository;


  // @Scheduled(cron = "*/5 * * * * ?") // cron at every xx:xx:05 second from 0 second
  // @Scheduled(cron = "0 * * * * ?") //  cron at every xx:xx:00 second from 0 second
  // @Async
  // @Scheduled(fixedRate = 5000)
  public void cronUserEntitiesToDB() throws InterruptedException {
    List<User> users = userService.getUsers();
    List<Post> posts = postService.getPosts();

    // Prepare Data for Serializable
    List<UserEntity> userEntities = new ArrayList<>();

    for (User user : users) {

      // Prepare UserEntity
      UserEntity userEntity = requestDTOMapper.mapToUserEntity(user, posts);

      userEntities.add(userEntity);

    }

    userRepository.deleteAll();
    userRepository.saveAll(userEntities);
    System.out.println("Update Time:" + LocalDateTime.now());
  }

  // @Scheduled(fixedRate = 2000)
  // public void fixedRateTask() throws InterruptedException {
  // System.out.println("start: fixedRateTask " + System.currentTimeMillis());;
  // Thread.sleep(1000);
  // System.out.println("end: fixedRateTask");
  // }

  // // @Scheduled(fixedDelay = 2000)
  // public void fixedDelayTask() throws InterruptedException {
  // System.out.println("start: fixedDelayTask " + System.currentTimeMillis());
  // Thread.sleep(1000);
  // System.out.println("end: fixedDelayTask");
  // }

  // @Scheduled(cron = "*/5 * * * * ?") // every xx:xx:05, for every 60 seconds
  // @Scheduled(cron = "5 * * * * ?") // every 5 sec, similar to fixedDelay
  // @Async
  // public void cronTask5() throws InterruptedException {
  // System.out.println("start cronTask5");
  // Thread.sleep(10000);
  // System.out.println("end cronTask5");
  // }

  // // @Scheduled(cron = "10 * * * * ?") // every 5 sec, similar to fixedDelay
  // @Async
  // public void cronTask10() throws InterruptedException {
  // System.out.println("start cronTask10");
  // Thread.sleep(10000);
  // System.out.println("end cronTask10");
  // }

}
