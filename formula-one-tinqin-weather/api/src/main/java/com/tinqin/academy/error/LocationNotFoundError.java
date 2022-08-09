package com.tinqin.academy.error;

import com.tinqin.academy.base.Error;
import org.springframework.http.HttpStatus;

public class LocationNotFoundError implements Error {
    @Override
    public HttpStatus getCode() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public String getMessage() {
        return "Location not found";
    }
}
