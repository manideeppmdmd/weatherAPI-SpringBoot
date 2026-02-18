package com.manideep.weather.exceptions;

import com.manideep.weather.DTOs.ApiResponse;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CityNotFoundException.class)
  public ResponseEntity<ApiResponse<Void>> handleCityNotFoundException(
    CityNotFoundException ex
  ) {
    ApiError error = new ApiError("CITY NOT FOUND", ex.getMessage(), "city");

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
      ApiResponse.error(List.of(error))
    );
  }

  @ExceptionHandler(InvalidApiKeyException.class)
  public ResponseEntity<ApiResponse<Void>> handleInvalidApiKeyException(
    InvalidApiKeyException ex
  ) {
    ApiError error = new ApiError("INVALID API KEY", ex.getMessage(), null);

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
      ApiResponse.error(List.of(error))
    );
  }

  @ExceptionHandler(WeatherServiceUnavailableException.class)
  public ResponseEntity<
    ApiResponse<Void>
  > handleWeatherServiceUnavailableException(
    WeatherServiceUnavailableException ex
  ) {
    ApiError error = new ApiError("WEATHER API ERROR", ex.getMessage(), null);

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
      ApiResponse.error(List.of(error))
    );
  }
}
