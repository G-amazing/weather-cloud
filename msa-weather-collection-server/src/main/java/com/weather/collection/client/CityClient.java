package com.weather.collection.client;

import com.weather.collection.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient("weather-city")
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;

}
