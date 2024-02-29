package com.vtxlab.bootcamp.bootcampsbforum.infra;

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
@ToString()
public class ApiResp<T> {

  private String code;

  private String message;

  private T data;

  private ApiResp(ApiResponseBuilder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public T getData() {
    return this.data;
  }

  public static <U> ApiResponseBuilder<U> builder() {
    return new ApiResponseBuilder<>();
  }

  public static class ApiResponseBuilder<U> {

    private String code;

    private String message;

    private U data;

    {
      this.code = Syscode.OK.getCode();
      this.message = Syscode.OK.getMessage();
    }

    public ApiResponseBuilder<U> code(String code) {
      this.code = code;
      return this;
    }

    public ApiResponseBuilder<U> message(String message) {
      this.message = message;
      return this;
    }

    public ApiResponseBuilder<U> data(U data) {
      this.data = data;
      return this;
    }

    public ApiResponseBuilder<U> ok() {
      this.code = Syscode.OK.getCode();
      this.message = Syscode.OK.getMessage();
      return this;
    }

    public ApiResponseBuilder<U> status(Syscode syscode) {
      // if (syscode == null) throw xxxException
      this.code = syscode.getCode();
      this.message = syscode.getMessage();
      return this;
    }

    public ApiResp<U> build() {

      // check if code and message has value
      if (this.code == null || this.message == null) {
        throw new RuntimeException();
      }

      // Double checking
      // throw exception if not valid
      return new ApiResp<U>(this);
    }
  }

  public static void main(String[] args) {
    ApiResp<String> apiResponse = ApiResp.<String>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data("Hello World") //
        .build();

    ApiResp<String> apiResponse2 = ApiResp.<String>builder() //
        .ok() //
        .data("Hello World") //
        .build();

    ApiResp<String> apiResponse3 = ApiResp.<String>builder() //
        .data("Hello World") //
        .build();

    ApiResp<String> apiResponse4 = ApiResp.<String>builder() //
        .status(Syscode.OK) //
        .data("Hello World") //
        .build();

    ApiResp<String> apiResponse5 = ApiResp.<String>builder() //
        .status(Syscode.NOTFOUND) //
        .data(null) //
        .build();

    System.out.println(apiResponse.toString());
    System.out.println(apiResponse2.toString());
    System.out.println(apiResponse3.toString());
    System.out.println(apiResponse4.toString());
    System.out.println(apiResponse5.toString());



  }


}
