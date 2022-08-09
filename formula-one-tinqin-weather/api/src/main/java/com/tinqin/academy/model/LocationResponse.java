package com.tinqin.academy.model;

import com.tinqin.academy.base.OperationResult;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
public class LocationResponse implements OperationResult {
    private String temperature;
    private String humidity;
    private String condition;
}
