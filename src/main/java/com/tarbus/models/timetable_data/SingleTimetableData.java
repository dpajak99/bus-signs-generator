package com.tarbus.models.timetable_data;

import com.tarbus.models.schedule.*;
import lombok.Getter;
import lombok.Setter;
import com.tarbus.models.DeparturesWrapper;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SingleTimetableData implements TimetableData {
    private StopModel stop;
    private RouteModel route;

    private RouteConnectionModel routeConnection;

    private List<RouteConnectionModel> routeConnections;

    private DeparturesWrapper departures;
    private List<SymbolModel> destinations = new ArrayList<>();
    
    public LineModel getLine() {
        return route.getLine();
    }
    
    public List<RouteConnectionModel> getRouteConnectionsFromNow() {
        int index = routeConnections.indexOf(routeConnection);
        return routeConnections.subList(index, routeConnections.size());
    }
    
    public List<String> getCitiesFromNow() {
        return getRouteConnectionsFromNow().stream().map(RouteConnectionModel::getStop).map(StopModel::getCity).distinct().toList();
    }
}
