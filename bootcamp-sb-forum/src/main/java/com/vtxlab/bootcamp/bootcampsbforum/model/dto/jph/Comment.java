package com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@Builder // for testing
public class Comment {

  private int postId;
  private int id;
  private String name;
  private String email;
  private String body;
  
}
