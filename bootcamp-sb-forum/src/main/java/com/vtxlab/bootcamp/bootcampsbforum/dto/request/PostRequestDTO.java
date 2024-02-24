package com.vtxlab.bootcamp.bootcampsbforum.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PostRequestDTO {

  private String title;
  private String body;

}
