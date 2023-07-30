package com.daonplace.springbootweb.dto.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AirPollutionInfo {
    private String pm10Value;
    private String pm25Value;
}
