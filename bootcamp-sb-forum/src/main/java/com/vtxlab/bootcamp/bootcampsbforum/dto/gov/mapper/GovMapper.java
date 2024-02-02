package com.vtxlab.bootcamp.bootcampsbforum.dto.gov.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public class GovMapper {

  public static UserPostDTO map(User user, List<Post> posts) {

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
        .id(user.getId()).username(user.getUsername()) //
        .email(user.getEmail()) //
        .phone(user.getPhone()) //
        .postDTOs(postDTOs) //
        .build();
  }
}
