package com.vtxlab.bootcamp.bootcampsbforum.dto.gov;
// Use path to distinguish the service target

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDTO {

  private int id;
  private String title;
  private String body;
  
}
