package com.tinqin.academy.base;

import org.springframework.http.HttpStatus;

public interface Error {
    HttpStatus getCode();
    String getMessage();
}
