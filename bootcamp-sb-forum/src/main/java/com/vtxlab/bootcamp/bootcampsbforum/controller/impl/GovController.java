package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.LinkedList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.GovOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.mapper.GovMapper;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.CommentService;
import com.vtxlab.bootcamp.bootcampsbforum.service.GovService;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;

@RestController
@RequestMapping(value = "/gov/api/v1")
public class GovController implements GovOperation {

  @Autowired
  private PostService postService;

  // Autowired GovService instead of UserService
  @Autowired
  //private UserService userService;
  private GovService govService;

  @Autowired
  private CommentService commentService;

  @Autowired
  private GovMapper govMapper;

  @Autowired 
  private ModelMapper modelMapper;

  public ApiResponse<UserPostDTO> getUser(int userId) {

    // 1. User service
    // 2. Post service
    // 3. relate the user and post
    // 4. build UserPostDTO object
    // 5. return UserPostDTO object

    // Use GovService instead
    //User user = userService.getUser(userId); // Not Found exception done by Service class and Global Exception Handler
    User user = govService.getUser(userId);

    UserPostDTO userPostDTO = govMapper.map(user, postService.getPosts());

    ApiResponse<UserPostDTO> apiResp = ApiResponse.<UserPostDTO>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(userPostDTO) //
        .build();

    return apiResp;

  }

  @Override
  public ApiResponse<List<UserPostDTO>> getUsers() {
    // List<User> users = userService.getUsers();
    
    List<User> users = govService.getUsers();
    List<Post> posts = postService.getPosts();

    List<UserPostDTO> userPostDTOs = new LinkedList<>();

    for (User user: users) {
      userPostDTOs.add(govMapper.map(user, posts));
    }

    ApiResponse<List<UserPostDTO>> apiResp = ApiResponse.<List<UserPostDTO>>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(userPostDTOs) //
        .build();

    return apiResp;

  }

  @Override
  public UserCommentDTO getUserComments(Long userId) {
    // User user = userService.getUser(userId);
    User user = govService.getUser(userId);
    
    List<Comment> comments = commentService.getComments();

    return govMapper.mapUCDTO(user, comments);
    
  }

  // GlobalExceptionhandler -> NPE
  @Override
  public String testNPE() {
    String s = null;
    return s.concat("hello");
  }

  @Override
  public UserDTO testModelMapper() {

    User user = User.builder() //
        .id(3) //
        .name("Thomas") //
        .email("thomas@gmail.com") //
        .phone("20001234").build();

    return modelMapper.map(user, UserDTO.class);
    // return new ModelMapper().map(user, UserDTO.class);

  }





}
