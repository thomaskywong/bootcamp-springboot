package com.vtxlab.bootcamp.bootcampsbforum2.infra;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResp<T> {

  private String code;

  private String message;

  private T data;

  
}
