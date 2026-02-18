package com.manideep.weather.services;

import com.manideep.weather.DTOs.WeatherResponseDTO;

public interface IWeatherService {
  WeatherResponseDTO getWeatherAtCity(String cityName);
}
