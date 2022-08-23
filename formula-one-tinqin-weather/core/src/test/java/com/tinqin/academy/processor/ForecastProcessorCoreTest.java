package com.tinqin.academy.processor;

import com.tinqin.academy.model.LocationRequest;
import com.tinqin.academy.model.LocationResponse;
import com.tinqin.academy.weatherclient.model.Condition;
import com.tinqin.academy.weatherclient.model.Current;
import com.tinqin.academy.weatherclient.model.Forecast;
import com.tinqin.academy.weatherclient.model.Location;
import com.tinqin.academy.weatherclient.service.WeatherClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ForecastProcessorCoreTest {

    @Mock
    private WeatherClientService weatherClientService;

    @InjectMocks
    private ForecastProcessorCore forecastProcessorCore;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void process() {
        when(weatherClientService.getForecastByLatAndLon(10.0,10.0)).thenReturn(Forecast.builder()
                        .current(Current.builder()
                                .humidity(10)
                                .condition(Condition.builder()
                                        .text("Sunny")
                                        .build())
                                .temp_c(22.2)
                                .build())
                        .location(null)
                .build());
        LocationRequest locationRequest=new LocationRequest(10.0,10.0);

        LocationResponse locationResponse= LocationResponse.builder()
                .condition("Sunny")
                .temperature(String.valueOf(22.2)+ " Celsius")
                .humidity(String.valueOf(10)+ " %")
                .build();

        assertNotNull(forecastProcessorCore.process(locationRequest).get());
        assertEquals(locationResponse,forecastProcessorCore.process(locationRequest).get());


    }
}