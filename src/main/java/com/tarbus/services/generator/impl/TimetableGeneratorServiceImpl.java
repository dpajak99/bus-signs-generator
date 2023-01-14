package com.tarbus.services.generator.impl;

import com.tarbus.builders.TimetableDocumentBuilder;
import com.tarbus.builders.TimetablePdfBuilder;
import com.tarbus.dto.request.generate_timetable_request.GenerateTimetableRequest;
import com.tarbus.dto.request.generate_timetable_request.RouteConfigDto;
import com.tarbus.models.TimetablePdfBuilderResult;
import com.tarbus.services.generator.TimetableGeneratorService;
import com.tarbus.models.RouteTimetable;
import com.tarbus.dto.response.generate_timetable_response.GenerateTimetableResponse;
import com.tarbus.dto.response.generate_timetable_response.GenerateTimetableResponseImpl;
import com.tarbus.services.generator.TimetableService;
import com.tarbus.services.jpa.RouteService;
import com.tarbus.models.TimetableBuilderInput;
import com.tarbus.models.TimetableBuilderOutput;
import com.tarbus.utils.file_naming_policy.FileNamingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        timetableDocumentBuilder.setFileNamingPolicy(FileNamingPolicy.fromType(generateTimetableRequest.getFileNamingPolicy()));

        List<Long> routesId = generateTimetableRequest.getRouteConfigDtoList().stream().map(RouteConfigDto::getRouteId).toList();
        List<RouteTimetable> routeTimetables = timetableService.getRouteTimetablesByRoutesId(routesId);
        TimetableBuilderInput timetableBuilderInput = new TimetableBuilderInput();
        timetableBuilderInput.setRouteTimetables(routeTimetables);

        TimetableBuilderOutput timetableBuilderOutput = timetableDocumentBuilder.generate(timetableBuilderInput);
        List<TimetablePdfBuilderResult> singleTemplateFiles = new ArrayList<>();
        List<TimetablePdfBuilderResult> sharedTemplateFiles = new ArrayList<>();
        try {
            singleTemplateFiles = timetablePdfBuilder.saveAll(timetableBuilderOutput.getSingleTimetables(), "single");
            sharedTemplateFiles = timetablePdfBuilder.saveAll(timetableBuilderOutput.getSharedTimetables(), "shared");
        } catch (Exception e) {
            System.err.println("Cannot save pdf files");
            e.printStackTrace();
        }


        GenerateTimetableResponseImpl generateTimetableResponse = new GenerateTimetableResponseImpl();
        generateTimetableResponse.setSingleFiles(singleTemplateFiles);
        generateTimetableResponse.setSharedFiles(sharedTemplateFiles);
        return generateTimetableResponse;
    }
}
