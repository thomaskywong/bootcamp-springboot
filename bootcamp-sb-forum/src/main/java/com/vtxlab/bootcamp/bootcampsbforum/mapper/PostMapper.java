package com.vtxlab.bootcamp.bootcampsbforum.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.PostEntity;
import com.vtxlab.bootcamp.bootcampsbforum.model.Post2;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

@Component
public class PostMapper {

  @Autowired
  private ModelMapper modelMapper;

  public PostDTO postMapper(Post post) {

    return modelMapper.map(post, PostDTO.class);

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

  public PostEntity mapToEntity(Post post) {
    return new PostEntity((long) post.getId(), //
        (long) post.getUserId(), //
        post.getTitle(), //
        post.getBody());
  }

  public PostEntity mapToEntity(Post2 post) {
    return new PostEntity((long) post.getId(), //
        (long) post.getUserId(), //
        post.getTitle(), //
        post.getBody());
  }

  public Post mapToPost(PostEntity postEntity) {
    return Post.builder() //
               .id((int)(long) postEntity.getId()) //
               .userId((int)(long) postEntity.getUserId()) //
               .title(postEntity.getTitle()) //
               .body(postEntity.getBody())
               .build();
  }

  public Post2 mapToPost2(PostEntity postEntity) {
    return new Post2(postEntity.getId(), //
                     postEntity.getUserId(), //
                     postEntity.getTitle(), //
                     postEntity.getBody());
  }

}
