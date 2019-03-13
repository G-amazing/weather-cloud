package com.weather.collection.job;

import com.weather.collection.service.WeatherCollectionService;
import com.weather.collection.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private WeatherCollectionService weatherCollectionService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Weather Data Sync Job Start!");
        // 获取城市ID列表

        List<City> cityList = null;

        try {
            // TODO: 2019/3/12 改为由城市数据API微服务来提供数据
            cityList = new ArrayList<>();
            City city = new City();
            city.setCityId("101280101");
            cityList.add(city);

        } catch (Exception e) {
            log.error("Exception", e);
        }

        // 遍历城市ID获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            log.info("Weather Data Sync Job,cityId:" + cityId );
            weatherCollectionService.syncDataByCityId(cityId);
        }

        log.info("Weather Data Sync Job End!");
    }
}
