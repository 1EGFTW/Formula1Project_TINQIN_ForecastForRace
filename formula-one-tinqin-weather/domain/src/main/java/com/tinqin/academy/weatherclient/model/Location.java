package com.tinqin.academy.weatherclient.model;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Location{
    private String name;
    private String region;
    private String country;
    private double lat;
    private double lon;
    private String tz_id;
    private int localtime_epoch;
    private String localtime;
}