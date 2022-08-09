package com.tinqin.academy.error;

import com.tinqin.academy.base.Error;
import org.springframework.http.HttpStatus;

public class ForecastServiceUnavailableError implements Error {
    @Override
    public HttpStatus getCode() {
        return HttpStatus.SERVICE_UNAVAILABLE;
    }

    @Override
    public String getMessage() {
        return "Forecast Service UNAVAILABLE!";
    }
}
