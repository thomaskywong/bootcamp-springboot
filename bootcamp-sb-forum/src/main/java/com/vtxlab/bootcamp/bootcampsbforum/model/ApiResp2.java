package com.vtxlab.bootcamp.bootcampsbforum.model;


import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// import lombok.Builder;
// import lombok.Getter;

// ApiResponse.<User>builder().code(xxx).message(xxx).data().build();

// Serialization requires setter and getter to implement
// Deserialization (RestTemplate call) requires getter only
// Deserialization (controller (spring)) no getter or setter required

// RestTemplate.getForObject(key, Class<T> clazz) simular to RedisHelper.get(key, Class<T> clazz)

// @Getter
// @Builder
// public class ApiResponse<T extends Number> {
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString()
public class ApiResp2 {

  private String code;

  private String message;

  private List<UserDTO> data;


}
