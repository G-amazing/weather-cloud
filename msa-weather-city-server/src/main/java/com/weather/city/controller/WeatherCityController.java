package com.weather.city.controller;

import com.weather.city.service.WeatherCityService;
import com.weather.city.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class WeatherCityController {

    @Autowired
    private WeatherCityService weatherCityService;

    @GetMapping
    public List<City> getCityList() throws Exception {
        return weatherCityService.listCity();
    }

}
