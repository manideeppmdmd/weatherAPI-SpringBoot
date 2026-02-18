package com.manideep.weather.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.manideep.weather.exceptions.ApiError;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

  private T data;
  private Meta meta;
  private List<ApiError> errors;

  public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<>(data, null, null);
  }

  public static <T> ApiResponse<T> success(T data, Meta meta) {
    return new ApiResponse<>(data, meta, null);
  }

  public static <T> ApiResponse<T> error(List<ApiError> errors) {
    return new ApiResponse<>(null, null, errors);
  }
}
