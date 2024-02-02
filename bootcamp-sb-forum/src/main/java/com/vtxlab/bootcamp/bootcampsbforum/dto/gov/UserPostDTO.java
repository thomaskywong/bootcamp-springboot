package com.vtxlab.bootcamp.bootcampsbforum.dto.gov;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserPostDTO {

  private int id;
  private String username;
  private String email;
  private String phone;
  private List<PostDTO> postDTOs;
  
  
}
