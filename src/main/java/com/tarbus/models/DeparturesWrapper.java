package com.tarbus.models;

import com.tarbus.models.schedule.DepartureModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeparturesWrapper {
    private List<DepartureModel> departureModels;

    public DeparturesWrapper(List<DepartureModel> departureModels) {
        this.departureModels = departureModels;
    }
    
    public List<DepartureModel> getByDay(String dayName) {
        return departureModels.stream().filter((e) -> e.getTrack().getDays().contains(dayName)).toList();
    }
}
