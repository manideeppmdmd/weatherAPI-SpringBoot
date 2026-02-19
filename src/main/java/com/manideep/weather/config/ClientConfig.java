package com.manideep.weather.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientConfig {

  @Value("${API_URL}")
  private String apiURL;

  @Bean
  public RestClient restClient() {
    HttpComponentsClientHttpRequestFactory requestFactory =
      new HttpComponentsClientHttpRequestFactory();

    requestFactory.setConnectionRequestTimeout(3000);
    requestFactory.setReadTimeout(3000);

    return RestClient.builder()
      .baseUrl(apiURL)
      .requestFactory(requestFactory)
      .build();
  }
}
