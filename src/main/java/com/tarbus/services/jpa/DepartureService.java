package com.tarbus.services.jpa;

import com.tarbus.models.schedule.DepartureModel;

import java.util.List;

public interface DepartureService {
    List<DepartureModel> getByStopAndRoute(Long stopId, Long routeId);
}
