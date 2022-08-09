package com.tinqin.academy.processor;

import com.tinqin.academy.base.Error;
import com.tinqin.academy.error.ForecastServiceUnavailableError;
import com.tinqin.academy.model.LocationRequest;
import com.tinqin.academy.model.LocationResponse;
import com.tinqin.academy.operation.ForecastProcess;
import com.tinqin.academy.weatherclient.model.Forecast;
import com.tinqin.academy.weatherclient.exception.WeatherClientException;
import com.tinqin.academy.weatherclient.service.WeatherClientService;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;


@Service
public class ForecastProcessorCore implements ForecastProcess {
    private final WeatherClientService weatherClientService;

    public ForecastProcessorCore(WeatherClientService weatherClientService) {
        this.weatherClientService = weatherClientService;
    }

    @Override
    public Either<Error, LocationResponse> process(final LocationRequest input) {
        return Try.of(()->{
            final Forecast forecast=weatherClientService.getForecastByLatAndLon(input.getLat(),input.getLon());
            return LocationResponse.builder()
                    .temperature(String.valueOf(forecast.getCurrent().getTemp_c())+ " Celsius")
                    .humidity(String.valueOf(forecast.getCurrent().getHumidity())+ "%")
                    .condition(forecast.getCurrent().getCondition().getText())
                    .build();

        }).toEither()
            .mapLeft(throwable -> {
                if(throwable instanceof WeatherClientException){
                    return new ForecastServiceUnavailableError();
                }
                return new ForecastServiceUnavailableError();
            });
    }
}
