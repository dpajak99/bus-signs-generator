package com.tarbus.services.jpa.impl;

import com.tarbus.repositories.jpa.RouteConnectionRepository;
import com.tarbus.mappers.RouteConnectionMapper;
import com.tarbus.entity.RouteConnectionEntity;
import com.tarbus.services.jpa.RouteConnectionService;
import com.tarbus.models.schedule.RouteConnectionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteConnectionServiceImpl implements RouteConnectionService {
    final RouteConnectionRepository routeConnectionRepository;
    
    final RouteConnectionMapper routeConnectionMapper;

    @Autowired
    public RouteConnectionServiceImpl(RouteConnectionRepository routeConnectionRepository, RouteConnectionMapper routeConnectionMapper) {
        this.routeConnectionRepository = routeConnectionRepository;
        this.routeConnectionMapper = routeConnectionMapper;
    }

    @Override
    public List<RouteConnectionModel> getRouteConnectionsByRouteId(Long routeId) {
        List<RouteConnectionEntity> routeConnectionEntities = routeConnectionRepository.findAllByRouteIdOrderByLp(routeId);
        return routeConnectionMapper.mapToModels(routeConnectionEntities);
    }
}
