package com.manideep.weather.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class ClientConfig {

  @Value("${API_URL}")
  private String apiURL;

  @Bean
  public RestClient restClient() {
    DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(apiURL);

    return RestClient.builder().uriBuilderFactory(factory).build();
  }
}
