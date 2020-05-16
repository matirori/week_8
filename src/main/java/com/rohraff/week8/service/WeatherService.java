package com.rohraff.week8.service;

import com.rohraff.week8.client.WeatherClient;
import com.rohraff.week8.client.WeatherPojo.Weather;
import com.rohraff.week8.repository.BasicWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private WeatherClient weatherClient;

    @Autowired
    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    private Weather getWeatherByCity(String cityName) {
        return weatherClient.getWeatherData(cityName);
    }

    public BasicWeather checkWeather() {
        Weather weather = getWeatherByCity("Wejherowo");
        return new BasicWeather(weather.getMain().getTemp(),
                weather.getMain().getFeelsLike(),
                weather.getWind().getSpeed(),
                weather.getMain().getPressure());
    }
}
