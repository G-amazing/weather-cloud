package com.weather.city.service;

import com.weather.city.vo.City;
import java.util.List;

public interface WeatherCityService {
    List<City> listCity() throws Exception;
}
