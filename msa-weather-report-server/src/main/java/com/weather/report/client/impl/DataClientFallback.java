package com.weather.report.client.impl;

import com.weather.report.client.DataClient;
import com.weather.report.vo.City;
import com.weather.report.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataClientFallback implements DataClient {
    @Override
    public List<City> listCity() throws Exception {
        List<City> cityList = new ArrayList<>();

        City city1 = new City();
        city1.setCityId("101280601");
        city1.setCityName("深圳");
        cityList.add(city1);

        City city2 = new City();
        city2.setCityId("101280102");
        city2.setCityName("番禺");
        cityList.add(city2);
        return cityList;
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return null;
    }
}
