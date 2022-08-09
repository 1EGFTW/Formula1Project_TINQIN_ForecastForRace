package com.tinqin.academy.weatherclient.model;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Condition{
    private String text;
    private String icon;
    private int code;
}
