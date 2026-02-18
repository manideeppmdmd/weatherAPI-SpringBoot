package com.manideep.weather.controllers;

import com.manideep.weather.DTOs.ApiResponse;
import com.manideep.weather.DTOs.WeatherResponseDTO;
import com.manideep.weather.services.IWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WeatherController {

  private final IWeatherService weatherService;

  @GetMapping("/weather")
  public ResponseEntity<ApiResponse<WeatherResponseDTO>> getWeather(
    @RequestParam("city") String cityName
  ) {
    WeatherResponseDTO response = weatherService.getWeatherAtCity(cityName);

    return ResponseEntity.ok(ApiResponse.success(response));
  }
}
