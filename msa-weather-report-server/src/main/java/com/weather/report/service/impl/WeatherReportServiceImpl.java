package com.weather.report.service.impl;

import com.weather.report.service.WeatherReportService;
import com.weather.report.vo.Forecast;
import com.weather.report.vo.Weather;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    /**
     * 根据城市ID查询天气信息
     */
    @Override
    public Weather getDataByCityId(String cityId) {
        // TODO: 2019/3/12 改为有天气数据API微服务来提供
        Weather weather = new Weather();
        weather.setAqi("81");
        weather.setCity("上海");
        weather.setGanmao("易感冒");
        weather.setWendu("17");

        List<Forecast> forecastList = new ArrayList<>();
        Forecast forecast = new Forecast();
        forecast.setDate("2019-03-12");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecast.setHigh("19度");
        forecast.setLow("6度");
        forecastList.add(forecast);

        weather.setForecast(forecastList);
        return weather;
    }
}
