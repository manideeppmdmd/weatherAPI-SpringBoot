package com.manideep.weather.DTOs;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherResponseDTO {

  private Long id;
  private String city;
  private Double temperature;
  private String description;
  private Instant fetchedAt;
}
