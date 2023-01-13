package com.tarbus.infra.services.jpa;

import com.tarbus.models.schedule.RouteModel;

public interface RouteService {
    RouteModel getRouteById(Long id);
}
