package com.vtxlab.bootcamp.bootcampsbforum.exception;

import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;

public class JPHClientException extends BusinessRuntimeException {
  
  public JPHClientException(Syscode syscode) {
    super(syscode);
  }

}
