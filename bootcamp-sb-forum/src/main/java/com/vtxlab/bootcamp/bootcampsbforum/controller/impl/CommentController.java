package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.CommentOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.CommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.exception.ResourceNotFound;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.CommentService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

// @RestController
// @RequestMapping(value = "/api/v1")
public class CommentController implements CommentOperation {

  @Autowired
  private CommentService commentService;

  @Autowired
  private UserService userService;

  // Homework
  @Override
  public UserCommentDTO getUserComments(Long userId)
      throws ResourceNotFound {

    // Step 1: Check if User id value. Store User for filtering list of comments
    // Optional<User> userOptional = userService.getUsers().stream() //
    //     .filter(e -> e.getId() == userId) //
    //     .findFirst();

    // if (userOptional.isEmpty()) {
    //   throw new ResourceNotFound(Syscode.NOTFOUND);
    // }

    // User user = userOptional.get();
    User user = userService.getUser(userId);

    // Step 2: get List of commentDTOs from webServer
    List<CommentDTO> commentDTOs = commentService.getComments().stream() //
        .filter(e -> e.getPostId() == userId) //
        .map(e -> {
          return CommentDTO.builder() //
              .postId(e.getPostId()) //
              .name(e.getName()) //
              .email(e.getEmail()) //
              .body(e.getBody()) //
              .build();
        }) //
        .collect(Collectors.toList());

    // Step 3: wrap all gathered information into userCommentDTO and return
    UserCommentDTO userCommentDTO = UserCommentDTO.builder() //
        .id(user.getId()) //
        .username(user.getUsername()) //
        .email(user.getEmail()) //
        .phone(user.getPhone()) //
        .commentDTOs(commentDTOs) //
        .build();
    
    return userCommentDTO;


  }

}
