package com.vtxlab.bootcamp.bootcampsbforum.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Post2 {

  @JsonProperty(value = "userId")
  private Long userId;

  @JsonProperty(value = "id")
  private Long id;
  
  @JsonProperty(value = "title")
  private String title;
  
  @JsonProperty(value = "body")
  private String body;

}
