package com.tinqin.academy.rest.controller;

import com.tinqin.academy.base.Error;
import com.tinqin.academy.model.LocationRequest;
import com.tinqin.academy.model.LocationResponse;
import com.tinqin.academy.operation.ForecastProcess;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    private final ForecastProcess forecastProcess;

    public LocationController(ForecastProcess forecastProcess) {
        this.forecastProcess = forecastProcess;
    }

    @PostMapping("/getForecast")
    public ResponseEntity<?> getForecast(@RequestBody LocationRequest locationRequest){
        Either<Error, LocationResponse> responses=forecastProcess.process(locationRequest);
        if(responses.isLeft()){
            return ResponseEntity.status(responses.getLeft().getCode()).body(responses.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(responses.get());
    }
}
