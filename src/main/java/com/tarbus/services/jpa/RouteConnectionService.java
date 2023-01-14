package com.tarbus.services.jpa;

import com.tarbus.models.schedule.RouteConnectionModel;

import java.util.List;

public interface RouteConnectionService {
    List<RouteConnectionModel> getRouteConnectionsByRouteId(Long routeId);
}
