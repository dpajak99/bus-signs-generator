package com.tarbus.models.timetable_data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.tarbus.models.schedule.SymbolModel;
import com.tarbus.models.schedule.StopModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class MultiTimetableData implements TimetableData {
    private StopModel stop;
    private List<SymbolModel> symbols;

    private List<SingleTimetableData> schedules;

    public MultiTimetableData(List<SingleTimetableData> schedules) {
        this.schedules = schedules;
        this.stop = schedules.get(0).getStop();
        this.symbols = setupSymbols(schedules);
    }
    
    static List<SymbolModel> setupSymbols(List<SingleTimetableData> schedules) {
        Map<String, SymbolModel> destinationModelMap = new HashMap<>();
        for (SingleTimetableData schedule : schedules) {
            for(SymbolModel destination : schedule.getDestinations()) {
                boolean keyExists = destinationModelMap.containsKey(destination.getSymbol());
                if (keyExists && !destinationModelMap.get(destination.getSymbol()).equals(destination)) {
                    throw new RuntimeException("Destination symbols are not unique");
                } else {
                    destinationModelMap.put(destination.getSymbol(), destination);
                }
            }
        }
        return List.copyOf(destinationModelMap.values());
    }
    
    @Override
    public boolean isStopOnRequest() {
        if( schedules.isEmpty() ) {
            return false;
        }
        return schedules.get(0).getRouteConnection().getIsOptional() == 1;
    }
    
    @Override
    public StopModel getStop() {
        return stop;
    }
}
