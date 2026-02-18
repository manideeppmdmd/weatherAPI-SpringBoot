package com.manideep.weather.exceptions;

public class WeatherServiceUnavailableException extends RuntimeException {

  public WeatherServiceUnavailableException() {
    super("Weather API is currently unresponsive");
  }
}
