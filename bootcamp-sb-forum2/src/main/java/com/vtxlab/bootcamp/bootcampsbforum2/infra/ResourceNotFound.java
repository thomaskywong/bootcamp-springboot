package com.vtxlab.bootcamp.bootcampsbforum2.infra;

public class ResourceNotFound extends BusinessException {
  
  public ResourceNotFound(Syscode syscode) {
    super(syscode);
  }

}
