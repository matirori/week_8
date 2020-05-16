package com.rohraff.week8.client;

import com.rohraff.week8.client.WeatherPojo.Weather;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherClient {


    private RestTemplate restTemplate = new RestTemplate();

    private String buildUrl(String cityName) {
        String urlWeather = "https://community-open-weather-map.p.rapidapi.com/weather?&id=21&lang=pl&units=metric&q=";
        return urlWeather + cityName;
    }


    public Weather getWeatherData(String cityName) {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("x-rapidapi-host",  "community-open-weather-map.p.rapidapi.com");
        headers.add("x-rapidapi-key", "068fa023bcmsh20c99c10dcedd1ap1fcdb9jsn4955d22f6bef");
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<Weather> exchange = restTemplate.exchange(buildUrl(cityName),
                HttpMethod.GET,
                entity,
                Weather.class);

        return exchange.getBody();
    }
}
