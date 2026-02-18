package com.manideep.weather.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Meta {

  private Integer page;
  private Integer size;
  private Long total;
}
