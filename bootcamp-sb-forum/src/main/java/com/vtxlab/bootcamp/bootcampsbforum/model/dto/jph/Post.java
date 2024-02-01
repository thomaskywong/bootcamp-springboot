package com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
@EqualsAndHashCode
public class Post {

  private int userId;
  private int id;
  private String title;
  private String body;
  
}
