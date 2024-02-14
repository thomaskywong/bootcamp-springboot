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
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

// When Server Start,
// Spring ensures modelMapper is ready before creating GovMapper Object
@Component
public class GovMapper {

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
  public com.vtxlab.bootcamp.bootcampsbforum.entity.User mapEntity(User user) {
    return com.vtxlab.bootcamp.bootcampsbforum.entity.User.builder() //
        // .id((long) user.getId()) // No ID since this is only for internal use. Not seen or used by user
        .name(user.getName()) //
        .username(user.getUsername()) //
        .website(user.getWebsite()) //
        .addrLat(user.getAddress().getGeo().getLatitude()) //
        .addrLong(user.getAddress().getGeo().getLongtitude()) //
        // .addrLat(user.getAddress().getGeo().getLat()) //
        // .addrLong(user.getAddress().getGeo().getLng()) //
        .email(user.getEmail()) //
        .phone(user.getPhone()) //
        .street(user.getAddress().getStreet()) //
        .city(user.getAddress().getCity()) //
        .suite(user.getAddress().getSuite()) //
        .zipcode(user.getAddress().getZipcode()) //
        .cName(user.getCompany().getName()) //
        .cCatchPhrase(user.getCompany().getCatchPhrase()) //
        .cBusService(user.getCompany().getBusinessService()) //
        .build();         
  }

}
