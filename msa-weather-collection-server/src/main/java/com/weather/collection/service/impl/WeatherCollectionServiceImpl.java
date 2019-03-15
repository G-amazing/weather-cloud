package com.weather.collection.service.impl;

import com.weather.collection.service.WeatherCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherCollectionServiceImpl implements WeatherCollectionService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final long TIME_OUT = 10800L; //redis超时时间为3小时分钟
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    /**
     * 根据城市ID同步天气
     */
    @Override
    public void syncDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherDate(uri);
    }

    // 把天气数据放入缓存中
    private void saveWeatherDate(String uri) {

        String strBody = null;

        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);

        if (respString.getStatusCodeValue() == 200) {
            strBody = respString.getBody();
        }

        // 把查询出来的数据写入缓存中
        redisTemplate.opsForValue().set(uri,strBody,TIME_OUT,TimeUnit.SECONDS);

    }
}
