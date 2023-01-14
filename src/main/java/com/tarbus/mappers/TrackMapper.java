package com.tarbus.mappers;

import com.tarbus.models.schedule.TrackModel;
import com.tarbus.entity.TrackEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrackMapper {
    final RouteMapper routeMapper;

    @Autowired
    public TrackMapper(RouteMapper routeMapper) {
        this.routeMapper = routeMapper;
    }

    public TrackModel mapToModel(TrackEntity trackEntity) {
        TrackModel trackModel = new TrackModel();
        trackModel.setId(trackEntity.getId());
        trackModel.setRouteModel(routeMapper.mapToModel(trackEntity.getRoute()));
        trackModel.setDays(trackEntity.getDays());
        return trackModel;
    }
}
