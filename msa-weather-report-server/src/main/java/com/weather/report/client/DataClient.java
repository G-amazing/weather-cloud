package com.weather.report.client;

import com.weather.report.vo.City;
import com.weather.report.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient("weather-gateway")
public interface DataClient {

    /**
     * 获取城市列表
     */
    @GetMapping("city/cities")
    List<City> listCity() throws Exception;

    /**
     * 根据城市ID查询天气数据
     */
    @GetMapping("data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
