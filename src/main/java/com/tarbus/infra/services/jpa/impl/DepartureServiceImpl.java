package com.tarbus.infra.services.jpa.impl;

import com.tarbus.mappers.DepartureMapper;
import com.tarbus.models.schedule.DepartureModel;
import com.tarbus.infra.repositories.jpa.DepartureRepository;
import com.tarbus.infra.services.jpa.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartureServiceImpl implements DepartureService {
    final DepartureRepository departureRepository;
    final DepartureMapper departureMapper;

    @Autowired
    public DepartureServiceImpl(DepartureRepository departureRepository, DepartureMapper departureMapper) {
        this.departureRepository = departureRepository;
        this.departureMapper = departureMapper;
    }

    @Override
    public List<DepartureModel> getByStopAndRoute(Long stopId, Long routeId) {
        return departureMapper.mapToModel(departureRepository.findByStopAndRoute(stopId, routeId));
    }
}
