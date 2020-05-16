package com.rohraff.week8.controller;

import com.rohraff.week8.repository.WeatherRepo;
import com.rohraff.week8.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class WeatherSever {

    private WeatherRepo weatherRepo;
    private WeatherService weatherService;
    private static final Logger LOG = LoggerFactory.getLogger(WeatherService.class);

    @Autowired
    public WeatherSever(WeatherRepo weatherRepo, WeatherService weatherService) {
        this.weatherRepo = weatherRepo;
        this.weatherService = weatherService;
    }

    @Scheduled(cron = "0 0 0/1 * * ?")
    private void saveBySchedule() {
        weatherRepo.save(weatherService.checkWeather());
        LOG.info("METODA ZAPISU ZAININCJOWANA");
    }
}
