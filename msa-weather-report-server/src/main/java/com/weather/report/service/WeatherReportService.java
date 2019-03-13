package com.weather.report.service;

import com.weather.report.vo.Weather;

public interface WeatherReportService {
    Weather getDataByCityId(String cityId);
}
