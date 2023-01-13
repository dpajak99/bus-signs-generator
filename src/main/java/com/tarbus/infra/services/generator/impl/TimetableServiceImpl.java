package com.tarbus.infra.services.generator.impl;

import com.tarbus.models.DeparturesWrapper;
import com.tarbus.models.schedule.DepartureModel;
import com.tarbus.models.timetable_data.SingleTimetableData;
import com.tarbus.infra.services.jpa.DepartureService;
import com.tarbus.models.RouteTimetable;
import com.tarbus.models.StopTimetableConfig;
import com.tarbus.models.schedule.TimetableTemplateModel;
import com.tarbus.infra.services.generator.TimetableService;
import com.tarbus.infra.services.jpa.RouteConnectionService;
import com.tarbus.infra.services.jpa.RouteService;
import com.tarbus.infra.services.jpa.TimetableTemplateService;
import com.tarbus.models.schedule.RouteConnectionModel;
import com.tarbus.models.schedule.RouteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimetableServiceImpl implements TimetableService {
    final TimetableTemplateService timetableTemplateService;
    final RouteService routeService;
    final DepartureService departureService;
    final RouteConnectionService routeConnectionService;

    @Autowired
    public TimetableServiceImpl(TimetableTemplateService timetableTemplateService, RouteService routeService, DepartureService departureService, RouteConnectionService routeConnectionService) {
        this.timetableTemplateService = timetableTemplateService;
        this.routeService = routeService;
        this.departureService = departureService;
        this.routeConnectionService = routeConnectionService;
    }

    @Override
    public List<RouteTimetable> getRouteTimetablesByRoutesId(List<Long> routesId) {
        return routesId.stream().map(this::getRouteTimetableByRouteId).toList();
    }

    @Override
    public RouteTimetable getRouteTimetableByRouteId(Long routeId) {
        RouteModel route = routeService.getRouteById(routeId);
        
        TimetableTemplateModel timetableTemplate = timetableTemplateService.getTimetableTemplateByRouteId(routeId);
        List<RouteConnectionModel> routeConnectionModels = routeConnectionService.getRouteConnectionsByRouteId(routeId);
        List<StopTimetableConfig> stopTimetableConfigList = new ArrayList<>();
        for(RouteConnectionModel routeConnectionModel : routeConnectionModels) {
            List<DepartureModel> departures = departureService.getByStopAndRoute(routeConnectionModel.getStop().getId(), routeId);
            
            SingleTimetableData stopSingleTimetableData = new SingleTimetableData();
            stopSingleTimetableData.setStop(routeConnectionModel.getStop());
            stopSingleTimetableData.setRouteConnection(routeConnectionModel);
            stopSingleTimetableData.setRouteConnections(routeConnectionModels);
            stopSingleTimetableData.setRoute(routeConnectionModel.getRoute());
            stopSingleTimetableData.setDepartures(new DeparturesWrapper(departures));

            StopTimetableConfig stopTimetableConfig = new StopTimetableConfig();
            stopTimetableConfig.setRoute(routeConnectionModel.getRoute());
            stopTimetableConfig.setStop(routeConnectionModel.getStop());
            stopTimetableConfig.setSingleTimetableData(stopSingleTimetableData);
            stopTimetableConfig.setTimetableTemplate(timetableTemplate);

            stopTimetableConfigList.add(stopTimetableConfig);
        }

        RouteTimetable routeTimetable = new RouteTimetable();
        routeTimetable.setRoute(route);
        routeTimetable.setStopTimetableConfigs(stopTimetableConfigList);
        return routeTimetable;
    }
}
