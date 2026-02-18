package com.manideep.weather.DTOs;

import java.util.List;
import lombok.Getter;

@Getter
public class OpenWeatherAPIResponse {

  public Coord coord;
  public List<Weather> weather;
  public String base;
  public Main main;
  public int visibility;
  public Wind wind;
  public Clouds clouds;
  public int dt;
  public Sys sys;
  public Long id;
  public String name;
  public int cod;

  @Getter
  public static class Clouds {

    public int all;
  }

  @Getter
  public static class Coord {

    public double lon;
    public double lat;
  }

  @Getter
  public static class Main {

    public double temp;
    public int pressure;
    public int humidity;
    public double temp_min;
    public double temp_max;
  }

  @Getter
  public static class Sys {

    public int type;
    public int id;
    public double message;
    public String country;
    public int sunrise;
    public int sunset;
  }

  @Getter
  public static class Weather {

    public int id;
    public String main;
    public String description;
    public String icon;
  }

  @Getter
  public static class Wind {

    public double speed;
    public int deg;
  }
}
