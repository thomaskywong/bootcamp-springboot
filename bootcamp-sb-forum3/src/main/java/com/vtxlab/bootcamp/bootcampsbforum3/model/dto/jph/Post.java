package com.vtxlab.bootcamp.bootcampsbforum3.model.dto.jph;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Builder
@Getter
public class Post {

  private int userId;
  private int id;
  private String title;
  private String body;
  
}
