package com.tinqin.academy.rest;

import com.tinqin.academy.model.LocationRequest;
import com.tinqin.academy.model.LocationResponse;
import com.tinqin.academy.rest.controller.LocationController;
import com.tinqin.academy.weatherclient.model.Condition;
import com.tinqin.academy.weatherclient.model.Current;
import com.tinqin.academy.weatherclient.model.Forecast;
import com.tinqin.academy.weatherclient.model.Location;
import com.tinqin.academy.weatherclient.service.WeatherClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class RestApplicationTest {

    @Autowired
    private LocationController locationController;

    @MockBean
    private WeatherClientService weatherClientService;

    @Test
    void testGetForecast(){
        LocationRequest locationRequest=new LocationRequest(10.0,12.0);

        when(weatherClientService.getForecastByLatAndLon(10.0,12.0))
                .thenReturn(Forecast.builder()
                        .current(Current.builder()
                                .temp_c(20.0)
                                .humidity(99)
                                .condition(Condition.builder()
                                        .text("Sunny")
                                        .build())
                                .build())
                        .build());
        LocationResponse locationResponse= LocationResponse.builder()
                .humidity("99 %")
                .temperature("20.0 Celsius")
                .condition("Sunny")
                .build();

        ResponseEntity<LocationResponse> response=ResponseEntity.ok(locationResponse);

        Assertions.assertEquals(response,locationController.getForecast(locationRequest));

    }

}