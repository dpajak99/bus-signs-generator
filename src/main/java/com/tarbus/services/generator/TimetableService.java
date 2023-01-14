package com.tarbus.services.generator;

import com.tarbus.models.RouteTimetable;

import java.util.List;

public interface TimetableService {
    List<RouteTimetable> getRouteTimetablesByRoutesId(List<Long> routesId);
    RouteTimetable getRouteTimetableByRouteId(Long routeId);
}
