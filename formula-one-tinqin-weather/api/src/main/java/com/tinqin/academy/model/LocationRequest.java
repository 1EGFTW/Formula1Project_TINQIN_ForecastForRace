package com.tinqin.academy.model;

import com.tinqin.academy.base.OperationInput;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LocationRequest implements OperationInput {
    private Double lat;
    private Double lon;
}
