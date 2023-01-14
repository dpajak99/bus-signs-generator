package com.tarbus.services.jpa.impl;

import com.tarbus.entity.RouteEntity;
import com.tarbus.repositories.jpa.RouteRepository;
import com.tarbus.mappers.RouteMapper;
import com.tarbus.services.jpa.RouteService;
import com.tarbus.models.schedule.RouteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {
    final RouteRepository routeRepository;
    
    final RouteMapper routeMapper;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, RouteMapper routeMapper) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
    }

    @Override
    public RouteModel getRouteById(Long id) {
        Optional<RouteEntity> routeEntity = routeRepository.findById(id);
        return routeMapper.mapToModel(routeEntity.get());
    }
}
