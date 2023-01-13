package com.tarbus.models.schedule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrackModel {
    private String id;
    private RouteModel routeModel;
    private String days;
}
