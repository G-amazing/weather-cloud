package com.weather.report.service.impl;

import com.weather.report.client.DataClient;
import com.weather.report.service.WeatherReportService;
import com.weather.report.vo.Weather;
import com.weather.report.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DataClient dataClient;

    /**
     * 根据城市ID查询天气信息
     */
    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse resp = dataClient.getDataByCityId(cityId);
        return resp.getData();
    }
}
