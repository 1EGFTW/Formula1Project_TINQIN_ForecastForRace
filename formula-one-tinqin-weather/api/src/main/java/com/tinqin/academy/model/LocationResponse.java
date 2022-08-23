package com.tinqin.academy.model;

import com.tinqin.academy.base.OperationResult;
import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class LocationResponse implements OperationResult {
    private String temperature;
    private String humidity;
    private String condition;
}
