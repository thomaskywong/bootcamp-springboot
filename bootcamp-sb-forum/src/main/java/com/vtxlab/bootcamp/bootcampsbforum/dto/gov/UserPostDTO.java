package com.vtxlab.bootcamp.bootcampsbforum.dto.gov;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
public class UserPostDTO {

  private int id;
  private String username;
  private String email;
  private String phone;

  // add @Setter and 
  // @JsonProperty(value = "posts") for what purpose?
  @Setter
  @JsonProperty(value = "posts")
  private List<PostDTO> postDTOs;
  
  
}
