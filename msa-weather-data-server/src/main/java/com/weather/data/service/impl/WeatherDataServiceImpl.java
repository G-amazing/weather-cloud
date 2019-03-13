package com.weather.data.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.data.service.WeatherDataService;
import com.weather.data.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    /**
     * 根据城市ID查询天气数据
     */
    @Override
    public WeatherResponse getDataByCityId(final String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    /**
     * 根据城市名称查询天气数据
     */
    @Override
    public WeatherResponse getDataByCityName(final String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(String uri) {

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        String strBody = null;

        // 先从缓存中查询数据
        if (redisTemplate.hasKey(uri)) {
            log.info("从缓存中获取");
            strBody = redisTemplate.opsForValue().get(uri);

        } else {
            log.info("缓存中没有该数据");
            throw new RuntimeException("缓存中没有该数据!");
        }

        try {
            resp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {

            log.error("Error!",e);
        }
        return resp;
    }
}
