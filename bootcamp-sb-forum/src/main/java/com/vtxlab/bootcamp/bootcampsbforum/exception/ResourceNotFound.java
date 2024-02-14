package com.vtxlab.bootcamp.bootcampsbforum.exception;

import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;

public class ResourceNotFound extends BusinessRuntimeException {
  
  public ResourceNotFound(Syscode syscode) {
    super(syscode);
  }

}
