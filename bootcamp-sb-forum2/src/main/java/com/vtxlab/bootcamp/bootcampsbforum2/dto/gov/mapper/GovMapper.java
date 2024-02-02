package com.vtxlab.bootcamp.bootcampsbforum2.dto.gov.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.vtxlab.bootcamp.bootcampsbforum2.dto.gov.CommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum2.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum2.model.dto.jdh.Comment;
import com.vtxlab.bootcamp.bootcampsbforum2.model.dto.jdh.User;


public class GovMapper {

  public static UserCommentDTO map(User user, List<Comment> comments) {

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
}
