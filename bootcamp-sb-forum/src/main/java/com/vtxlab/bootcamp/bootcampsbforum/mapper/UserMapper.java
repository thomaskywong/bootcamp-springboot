package com.vtxlab.bootcamp.bootcampsbforum.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.CommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

// When Server Start,
// Spring ensures modelMapper is ready before creating GovMapper Object
@Component
public class UserMapper {

  // from @Configuration AppConfig Class @Bean
  @Autowired
  private ModelMapper modelMapper;


  // convert from User class object to UserDTO object
  public UserDTO map(User user) {
    // map all fields by name
    return this.modelMapper.map(user, UserDTO.class);
  }

  public UserCommentDTO mapUCDTO(User user, List<Comment> comments){
    List<CommentDTO> commentDTOs = comments.stream() //
        .filter(e -> e.getPostId() == user.getId()) //
        .map(e -> {
          return CommentDTO.builder() //
              .postId(e.getPostId()) //
              .name(e.getName()) //
              .email(e.getEmail()) //
              .body(e.getBody()) //
               .build();
        }).collect(Collectors.toList());

    return UserCommentDTO.builder() //
        .id(user.getId()) //
        .username(user.getUsername()) //
        .email(user.getEmail()) //
        .phone(user.getPhone()) //
        .commentDTOs(commentDTOs) //
        .build();
  }


  // By providing Given User object, and the whole list of Post,
  // return UserPostDTO to the client
  public UserPostDTO map(User user, List<Post> posts) {

    List<PostDTO> postDTOs = posts.stream() //
        .filter(e -> e.getUserId() == user.getId()) //
        .map(e -> {
          return PostDTO.builder() //
              .id(e.getId()) //
              .title(e.getTitle()) //
              .body(e.getBody())//
              .build();
        }).collect(Collectors.toList());

    return UserPostDTO.builder() //
        .id(user.getId()) //
        .username(user.getUsername()) //
        .email(user.getEmail()) //
        .phone(user.getPhone()) //
        .postDTOs(postDTOs) //
        .build();
    // ModelMapper mm = new ModelMapper();
  }

  // Mapper converts User object to User Entity Object to be stored in Database
  public UserEntity mapEntity(User user) {
    return new UserEntity((long) user.getId(), //
        user.getName(), //
        user.getUsername(), //
        user.getEmail(), //
        user.getPhone(), //
        user.getWebsite(), //
        user.getAddress().getStreet(), //
        user.getAddress().getSuite(), //
        user.getAddress().getCity(), //
        user.getAddress().getZipcode(), //
        user.getAddress().getGeo().getLatitude(), //
        user.getAddress().getGeo().getLongtitude(), //
        user.getCompany().getName(), //
        user.getCompany().getCatchPhrase(), //
        user.getCompany().getBusinessService(), 
        null);
        
  }

  

}
