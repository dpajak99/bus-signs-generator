package com.tarbus.mappers;

import com.tarbus.services.jpa.DepartureSymbolService;
import com.tarbus.models.schedule.DepartureModel;
import com.tarbus.models.schedule.TrackModel;
import com.tarbus.entity.DepartureEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartureMapper {
    final TrackMapper trackMapper;
    final DepartureSymbolService departureSymbolService;
    

    @Autowired
    public DepartureMapper(TrackMapper trackMapper, DepartureSymbolService departureSymbolService) {
        this.trackMapper = trackMapper;
        this.departureSymbolService = departureSymbolService;
    }

    public List<DepartureModel> mapToModel(List<DepartureEntity> departureEntities) {
        return departureEntities.stream().map(this::mapToModel).toList();
    }
    public DepartureModel mapToModel(DepartureEntity departureEntity) {
        TrackModel trackModel = trackMapper.mapToModel(departureEntity.getTrack());
        DepartureModel departureModel = new DepartureModel();
        departureModel.setTimeInMin(departureEntity.getTimeInMin());
        departureModel.setTrack(trackModel);
        departureModel.setSymbols(departureSymbolService.getBySymbolsNameAndRoute(departureEntity.getSymbols(), trackModel.getRouteModel().getId()));
        return departureModel;
    }
}
