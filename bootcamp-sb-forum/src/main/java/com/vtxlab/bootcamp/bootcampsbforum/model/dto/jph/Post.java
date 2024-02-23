package com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
@EqualsAndHashCode
public class Post {

   @JsonProperty(value = "user_id")
  private int userId;
  private int id;
  private String title;
  private String body;
  
}
