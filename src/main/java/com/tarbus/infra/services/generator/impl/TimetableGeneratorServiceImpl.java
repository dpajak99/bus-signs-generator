package com.tarbus.infra.services.generator.impl;

import com.tarbus.builders.TimetableDocumentBuilder;
import com.tarbus.builders.TimetablePdfBuilder;
import com.tarbus.infra.dto.request.generate_timetable_request.GenerateTimetableRequest;
import com.tarbus.infra.dto.request.generate_timetable_request.RouteConfigDto;
import com.tarbus.infra.services.generator.TimetableGeneratorService;
import com.tarbus.models.RouteTimetable;
import com.tarbus.infra.dto.response.generate_timetable_response.GenerateTimetableResponse;
import com.tarbus.infra.dto.response.generate_timetable_response.GenerateTimetableResponseImpl;
import com.tarbus.infra.services.generator.TimetableService;
import com.tarbus.infra.services.jpa.RouteService;
import com.tarbus.models.TimetableBuilderInput;
import com.tarbus.models.TimetableBuilderOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableGeneratorServiceImpl implements TimetableGeneratorService {
    final RouteService routeService;

    final TimetableService timetableService;

    @Autowired
    public TimetableGeneratorServiceImpl(RouteService routeService, TimetableService timetableService) {
        this.routeService = routeService;
        this.timetableService = timetableService;
    }

    @Override
    public GenerateTimetableResponse generateTimetable(GenerateTimetableRequest generateTimetableRequest) {
        TimetablePdfBuilder timetablePdfBuilder = new TimetablePdfBuilder();
        TimetableDocumentBuilder timetableDocumentBuilder = new TimetableDocumentBuilder();

        List<Long> routesId = generateTimetableRequest.getRouteConfigDtoList().stream().map(RouteConfigDto::getRouteId).toList();
        List<RouteTimetable> routeTimetables = timetableService.getRouteTimetablesByRoutesId(routesId);
        TimetableBuilderInput timetableBuilderInput = new TimetableBuilderInput();
        timetableBuilderInput.setRouteTimetables(routeTimetables);

        TimetableBuilderOutput timetableBuilderOutput = timetableDocumentBuilder.generate(timetableBuilderInput);
        
        try {
            timetablePdfBuilder.saveAll(timetableBuilderOutput.getSingleTimetables(), "single");
            timetablePdfBuilder.saveAll(timetableBuilderOutput.getSharedTimetables(), "shared");
        } catch (Exception e) {
            e.printStackTrace();
        }


        GenerateTimetableResponseImpl generateTimetableResponse = new GenerateTimetableResponseImpl();
        return generateTimetableResponse;
    }
}
