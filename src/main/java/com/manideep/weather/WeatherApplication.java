package com.manideep.weather;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApplication {

  public static void main(String[] args) {
    Dotenv dotEnv = Dotenv.configure().load();

    dotEnv
      .entries()
      .forEach((DotenvEntry entry) ->
        System.setProperty(entry.getKey(), entry.getValue())
      );

    SpringApplication.run(WeatherApplication.class, args);
  }
}
