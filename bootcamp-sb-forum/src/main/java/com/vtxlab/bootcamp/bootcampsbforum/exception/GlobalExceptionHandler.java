package com.vtxlab.bootcamp.bootcampsbforum.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestControllerAdvice // Bean: @ControllerAdvice + @ResponseBody
public class GlobalExceptionHandler {

  @ExceptionHandler(InvalidUserIdException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> invalidUserIdExceptionHandler(InvalidUserIdException ex) {
    return ApiResp.<Void>builder() //
        .status(Syscode.INVALID_USERID) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> ConstraintViolationExceptionHandler(ConstraintViolationException ex) {
    return ApiResp.<Void>builder() //
        .status(Syscode.INVALID_USERID) //
        .data(null) //
        .build();
  }

  // Catch customized Exception class - JPHClientException.class
  @ExceptionHandler(JPHClientException.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT) // http status: 408
  // @ResponseStatus is an alternative of ResponseEntity<>
  public ApiResp<Void> jphClientExceptionHandler(JPHClientException ex) {
    return ApiResp.<Void>builder() //
        .code(Syscode.JPH_NOT_AVAILABLE.getCode()) //
        .message(Syscode.JPH_NOT_AVAILABLE.getMessage()) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(RestClientException.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResp<Void> jphClientExceptionHandler(RestClientException ex) {
    return ApiResp.<Void>builder() //
        .code(Syscode.REST_CLIENT_EXEPTION.getCode()) //
        .message(Syscode.REST_CLIENT_EXEPTION.getMessage()) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(ResourceNotFound.class)
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResp<Void> ResourceNotFoundExceptionHandler(
      ResourceNotFound ex) {
    return ApiResp.<Void>builder() //
        .code(Syscode.JPH_NOT_AVAILABLE.getCode()) //
        .message(Syscode.JPH_NOT_AVAILABLE.getMessage()) //
        .data(null) //
        .build();
  }

  // NPE - NullPointerException. Catch null pointer
  @ExceptionHandler(NullPointerException.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResp<Void> npeExceptionHandler(NullPointerException ex) {
    return ApiResp.<Void>builder() //
        .code(Syscode.NPE_EXCEPTION.getCode()) //
        .message(Syscode.NPE_EXCEPTION.getMessage()) //
        .data(null) //
        .build();
  }

  // Last exception handler: handle all possible Exception
  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResp<Void> ExceptionHandler(Exception ex) {
  return ApiResp.<Void>builder() //
  .code(Syscode.GENERAL_EXCEPTION.getCode()) //
  .message(Syscode.GENERAL_EXCEPTION.getMessage()) //
  .data(null) //
  .build();
  }

}
