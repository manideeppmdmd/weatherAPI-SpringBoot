package com.manideep.weather.services;

import com.manideep.weather.DTOs.WeatherResponseDTO;
import com.manideep.weather.gateway.IWeatherGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService implements IWeatherService {

  private final IWeatherGateway weatherGateway;

  @Override
  public WeatherResponseDTO getWeatherAtCity(String cityName) {
    return this.weatherGateway.getWeatherAtCity(cityName);
  }
}
