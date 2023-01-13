package com.tarbus.infra.services.jpa;

import com.tarbus.models.schedule.SymbolModel;

import java.util.List;

public interface DepartureSymbolService {
    List<SymbolModel> getBySymbolsNameAndRoute(String symbols, Long routeId);
}
