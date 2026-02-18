package com.manideep.weather.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiError {

  private String code;
  private String message;
  private String field;
}
