package com.tarbus.services.jpa;

import com.tarbus.models.schedule.RouteModel;

public interface RouteService {
    RouteModel getRouteById(Long id);
}
