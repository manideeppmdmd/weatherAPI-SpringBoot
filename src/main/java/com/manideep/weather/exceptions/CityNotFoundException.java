package com.manideep.weather.exceptions;

public class CityNotFoundException extends RuntimeException {

  public CityNotFoundException(String city) {
    super("City not found: " + city);
  }
}
