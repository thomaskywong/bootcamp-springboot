package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.GovOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.mapper.GovMapper;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@RestController
@RequestMapping(value = "/gov/api/v1")
public class GovController implements GovOperation {

  @Autowired
  private PostService postService;

  @Autowired
  private UserService userService;

  @Autowired
  private GovMapper govMapper;

  @Autowired 
  private ModelMapper modelMapper;

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



  public ApiResponse<UserPostDTO> getUsers(int userId) {

    // 1. User service
    // 2. Post service
    // 3. relate the user and post
    // 4. build UserPostDTO object
    // 5. return UserPostDTO object

    // Optional<User> userOp = userService.getUsers().stream() //
    // .filter(e -> e.getId() == userId) //
    // .findFirst(); //

    // User user;
    // if (userOp.isPresent()) {
    // user = userOp.get();
    // } else {
    // // error message
    // }


    // Extract data by using stream()
    // List<PostDTO> postDTOs = postService.getPosts().stream() //
    // .filter(e -> e.getUserId() == userId) //
    // .map(e -> {
    // return PostDTO.builder() //
    // .id(e.getId()) //
    // .title(e.getTitle()) //
    // .body(e.getBody()) //
    // .build();
    // }) //
    // .collect(Collectors.toList());



    // Optional<UserPostDTO> userPostDTO = userService.getUsers() //
    // .stream() //
    // .filter(e -> e.getId() == userId) //
    // .map(e -> { //
    // List<Post> posts = postService.getPosts(); //
    // return GovMapper.map(e, posts); // wrap to UserPostDTO
    // }) //
    // .findFirst();

    // if (userPostDTO.isPresent()) {
    // ApiResponse<UserPostDTO> apiResp = ApiResponse.<UserPostDTO>builder() //
    // .code(Syscode.OK.getCode()) //
    // .message(Syscode.OK.getMessage()) //
    // .data(userPostDTO.get()) // extract information from Optional<UserPostDTO> userPostDTO
    // .build();

    // return ResponseEntity.ok(apiResp); // ResponseEntity.ok .> http status = 200
    // }
    // throw new ResourceNotFound(Syscode.NOTFOUND);

    // return ResponseEntity.noContent().build(); // ResponseEntity.noContent() .> http status = 204

    // return UserPostDTO.builder().id(user.getId()).username(user.getUsername()).email(user.getEmail())
    // .phone(user.getPhone()).postDTOs(postDTOs).build();

    User user = userService.getUser(userId); // Not Found exception done by Service class and Global Exception Handler

    
    // List<PostDTO> postDTOs = postService.getPosts().stream() //
    //     .filter(e -> e.getUserId() == userId) //
    //     .map(e -> {
    //       return PostDTO.builder() //
    //           .id(e.getId()) //
    //           .title(e.getTitle()) //
    //           .body(e.getBody()) //
    //           .build();
    //     }) //
    //     .collect(Collectors.toList());

    // UserPostDTO userPostDTO = UserPostDTO.builder() //
    //     .username(user.getUsername()) //
    //     .email(user.getEmail()) //
    //     .phone(user.getPhone()) //
    //     .postDTOs(postDTOs) //
    //     .build();

    UserPostDTO userPostDTO = govMapper.map(user, postService.getPosts());

    ApiResponse<UserPostDTO> apiResp = ApiResponse.<UserPostDTO>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(userPostDTO) //
        .build();

    return apiResp;

  }

  // GlobalExceptionhandler -> NPE
  @Override
  public String testNPE() {
    String s = null;
    return s.concat("hello");
  }


}
