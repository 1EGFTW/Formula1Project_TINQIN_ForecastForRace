package com.tinqin.academy.weatherclient.service;

import com.tinqin.academy.weatherclient.exception.WeatherClientException;
import com.tinqin.academy.weatherclient.model.Forecast;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherClientService {
    private final RestTemplate restTemplate;

    public WeatherClientService() {
        this.restTemplate = new RestTemplate();
    }


    public Forecast getForecastByLatAndLon(Double lat,Double lon){
        final String key = "c782585acdc84252b3790106220807";

        final String uri = "http://api.weatherapi.com/v1/current.json?key=" + key + "&q=" + lat
                + "," + lon;

        try {
            return restTemplate.getForObject(uri, Forecast.class);
        }catch (Exception e){
            throw new WeatherClientException();
        }
    }

}
