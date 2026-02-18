package com.manideep.weather.gateway;

import com.manideep.weather.DTOs.WeatherResponseDTO;

public interface IWeatherGateway {
  WeatherResponseDTO getWeatherAtCity(String cityName);
}
