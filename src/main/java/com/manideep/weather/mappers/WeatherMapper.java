package com.manideep.weather.mappers;

import com.manideep.weather.DTOs.OpenWeatherAPIResponse;
import com.manideep.weather.DTOs.WeatherResponseDTO;
import java.time.Instant;

public class WeatherMapper {

  public static WeatherResponseDTO toDTO(OpenWeatherAPIResponse apiResponse) {
    String description = null;
    if (
      apiResponse.getWeather() != null && !apiResponse.getWeather().isEmpty()
    ) {
      description = apiResponse.getWeather().get(0).getDescription();
    }

    return WeatherResponseDTO.builder()
      .id(apiResponse.getId())
      .city(apiResponse.getName())
      .temperature(apiResponse.getMain().getTemp())
      .description(description)
      .fetchedAt(Instant.now())
      .build();
  }
}
