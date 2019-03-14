package com.weather.report.client;

import com.weather.report.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("weather-city")
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;

}
