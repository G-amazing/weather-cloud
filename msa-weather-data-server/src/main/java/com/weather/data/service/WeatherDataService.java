package com.weather.data.service;

import com.weather.data.vo.WeatherResponse;

public interface WeatherDataService {

    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);
}
