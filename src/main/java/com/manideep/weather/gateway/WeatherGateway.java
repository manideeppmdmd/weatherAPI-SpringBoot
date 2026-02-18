package com.manideep.weather.gateway;

import com.manideep.weather.DTOs.OpenWeatherAPIResponse;
import com.manideep.weather.DTOs.WeatherResponseDTO;
import com.manideep.weather.exceptions.CityNotFoundException;
import com.manideep.weather.exceptions.InvalidApiKeyException;
import com.manideep.weather.exceptions.WeatherServiceUnavailableException;
import com.manideep.weather.mappers.WeatherMapper;
import java.net.URI;
import java.time.Duration;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Component
public class WeatherGateway implements IWeatherGateway {

  private final RestClient restClient;

  @Value("${API_KEY}")
  private String apiKey;

  private WeatherResponseDTO cachedWeather;

  public WeatherGateway(RestClient _restClient) {
    this.restClient = _restClient;
  }

  @Retryable(
    retryFor = {
      RestClientException.class,
      ResourceAccessException.class,
      WeatherServiceUnavailableException.class,
    },
    maxAttempts = 1
  )
  @Override
  public WeatherResponseDTO getWeatherAtCity(String cityName) {
    try {
      boolean isOlderThan30Mins =
        this.cachedWeather == null ||
        this.cachedWeather.getFetchedAt().isBefore(
          Instant.now().minus(Duration.ofMinutes(30))
        ) ||
        !this.cachedWeather.getCity().equals(cityName);

      if (isOlderThan30Mins) {
        OpenWeatherAPIResponse response = restClient
          .get()
          .uri(uriBuilder -> {
            URI finalUri = uriBuilder
              .queryParam("q", cityName)
              .queryParam("appid", apiKey)
              .queryParam("units", "imperial")
              .build();
            //log.info("OpenWeather final URL: {}", finalUri);
            return finalUri;
          })
          .retrieve()
          .onStatus(
            status -> status.value() == 401,
            (req, res) -> {
              throw new InvalidApiKeyException();
            }
          )
          .onStatus(
            status -> status.value() == 404,
            (req, res) -> {
              throw new CityNotFoundException(cityName);
            }
          )
          .onStatus(HttpStatusCode::is5xxServerError, (req, res) -> {
            throw new WeatherServiceUnavailableException();
          })
          .body(OpenWeatherAPIResponse.class);

        WeatherResponseDTO weatherDTO = WeatherMapper.toDTO(response);
        this.cachedWeather = weatherDTO;
      }

      return this.cachedWeather;
    } catch (ResourceAccessException e) {
      throw new WeatherServiceUnavailableException();
    }
  }
}
