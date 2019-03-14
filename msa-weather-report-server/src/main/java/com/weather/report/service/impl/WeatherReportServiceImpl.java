package com.weather.report.service.impl;

import com.weather.report.client.WeatherDataClient;
import com.weather.report.service.WeatherReportService;
import com.weather.report.vo.Forecast;
import com.weather.report.vo.Weather;
import com.weather.report.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataClient weatherDataClient;

    /**
     * 根据城市ID查询天气信息
     */
    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse resp = weatherDataClient.getDataByCityId(cityId);
        return resp.getData();
    }
}
