package com.vtxlab.bootcamp.bootcampsbforum.infra;

// import lombok.Builder;
// import lombok.Getter;

// ApiResponse.<User>builder().code(xxx).message(xxx).data().build();

// Serialization requires setter and getter to implement
// Deserialization (RestTemplate call) requires getter only
// Deserialization (controller (spring)) no getter or setter required

// RestTemplate.getForObject(key, Class<T> clazz) simular to RedisHelper.get(key, Class<T> clazz)

// @Getter
// @Builder
public class ApiResponse<T> {

  private String code;

  private String message;

  private T data;

  private ApiResponse(ApiResponseBuilder<T> builder) {
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

    public ApiResponse<U> build() {
      return new ApiResponse<U>(this);
    }


  }

  
}
