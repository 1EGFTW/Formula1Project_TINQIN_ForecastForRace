package com.tinqin.academy.weatherclient.model;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Forecast {
    private Location location;
    private Current current;
}
