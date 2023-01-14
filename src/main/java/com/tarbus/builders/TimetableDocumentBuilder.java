package com.tarbus.builders;

import com.tarbus.models.*;
import com.tarbus.models.schedule.RouteModel;
import com.tarbus.models.schedule.StopModel;
import com.tarbus.models.schedule.timetable_template_model.TimetableTemplateModel;
import com.tarbus.utils.file_naming_policy.FileNamingPolicy;
import com.tarbus.utils.file_naming_policy.RouteIdFileNamingPolicy;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class TimetableDocumentBuilder {
    private FileNamingPolicy fileNamingPolicy = new RouteIdFileNamingPolicy();
    
    public TimetableBuilderOutput generate(TimetableBuilderInput request) {
       
        Map<StopModel, List<StopTimetableConfig>> stopTimetables = request.getStopTimetables();
        List<TimetableDocumentStructure> singleTimetableDocuments = buildSingleTimetablesDocuments(request.getRouteTimetables());
        List<TimetableDocumentStructure> sharedTimetableDocuments = buildSharedTimetablesDocuments(stopTimetables);
        
        TimetableBuilderOutput timetableBuilderOutput = new TimetableBuilderOutput();
        timetableBuilderOutput.setSingleTimetables(singleTimetableDocuments);
        timetableBuilderOutput.setSharedTimetables(sharedTimetableDocuments);
        return timetableBuilderOutput;
    }
    
    private List<TimetableDocumentStructure> buildSingleTimetablesDocuments(List<RouteTimetable> routeTimetables) {
        Map<RouteModel, List<TimetablePageStructure>> singleTimetablesDocuments = new HashMap<>();
        for( RouteTimetable routeTimetable : routeTimetables ) {
            List<TimetablePageStructure> timetablePageStructureList = new ArrayList<>();
            for( StopTimetableConfig stopTimetableConfig : routeTimetable.getStopTimetableConfigs() ) {
                timetablePageStructureList.add(getTimetablePageStructure(List.of(stopTimetableConfig)));
            }
            singleTimetablesDocuments.put(routeTimetable.getRoute(), timetablePageStructureList);
        }

        List<TimetableDocumentStructure> singleTimetableDocuments = new ArrayList<>();
        for(Map.Entry<RouteModel, List<TimetablePageStructure>> singleTimetableEntry : singleTimetablesDocuments.entrySet()) {
            RouteModel routeModel = singleTimetableEntry.getKey();
            String fileName = getFileName(List.of(routeModel));

            TimetableDocumentStructure timetableDocumentStructure = new TimetableDocumentStructure();
            timetableDocumentStructure.setFileName(fileName);
            timetableDocumentStructure.setPages(singleTimetableEntry.getValue());
            singleTimetableDocuments.add(timetableDocumentStructure);
        }
        return singleTimetableDocuments;
    }
    
    private List<TimetableDocumentStructure> buildSharedTimetablesDocuments(Map<StopModel, List<StopTimetableConfig>> stopTimetables) {
        Map<RoutesWrapper, List<TimetablePageStructure>> sharedTimetables = new HashMap<>();
        for(Map.Entry<StopModel, List<StopTimetableConfig>> stopEntry : stopTimetables.entrySet()) {
            List<StopTimetableConfig> stopTimetableConfigs = stopTimetables.get(stopEntry.getKey());
            TimetablePageStructure timetablePageStructure = getTimetablePageStructure(stopTimetableConfigs);
            RoutesWrapper routes = new RoutesWrapper(new ArrayList<>(timetablePageStructure.getPageRoutes()));

            sharedTimetables.putIfAbsent(routes, new ArrayList<>());
            sharedTimetables.get(routes).add(timetablePageStructure);
        }

        List<TimetableDocumentStructure> sharedTimetableDocuments = new ArrayList<>();
        for(Map.Entry<RoutesWrapper, List<TimetablePageStructure>> sharedTimetableEntry : sharedTimetables.entrySet()) {
            List<RouteModel> routeModels = sharedTimetableEntry.getKey().getRouteModels();
            if(routeModels.size() < 2) continue;
            String fileName = getFileName(routeModels);

            TimetableDocumentStructure timetableDocumentStructure = new TimetableDocumentStructure();
            timetableDocumentStructure.setFileName(fileName);
            timetableDocumentStructure.setPages(sharedTimetableEntry.getValue());
            sharedTimetableDocuments.add(timetableDocumentStructure);
        }
        return sharedTimetableDocuments;
    }

    private TimetablePageStructure getTimetablePageStructure(List<StopTimetableConfig> stopTimetablesData) {
        TimetablePageStructure timetablePageStructure = new TimetablePageStructure();

        for (StopTimetableConfig stopTimetableConfig : stopTimetablesData) {
            TimetableTemplateModel timetableTemplate = stopTimetableConfig.getTimetableTemplate();
            timetablePageStructure.add(timetableTemplate, stopTimetableConfig.getSingleTimetableData());
        }

        return timetablePageStructure;
    }
    
    private String getFileName(List<RouteModel> routeModels) {
        return fileNamingPolicy.getFileName(routeModels);
    }
}

