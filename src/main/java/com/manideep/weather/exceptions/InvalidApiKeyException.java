package com.manideep.weather.exceptions;

public class InvalidApiKeyException extends RuntimeException {

  public InvalidApiKeyException() {
    super("Invalid OpenWeather API Key");
  }
}
