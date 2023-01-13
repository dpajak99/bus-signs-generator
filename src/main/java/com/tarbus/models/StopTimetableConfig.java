package com.tarbus.models;

import com.tarbus.models.timetable_data.SingleTimetableData;
import lombok.Getter;
import lombok.Setter;
import com.tarbus.models.schedule.TimetableTemplateModel;
import com.tarbus.models.schedule.RouteModel;
import com.tarbus.models.schedule.StopModel;

@Getter
@Setter
public class StopTimetableConfig {
    private RouteModel route;
    private StopModel stop;
    private SingleTimetableData singleTimetableData = new SingleTimetableData();
    private TimetableTemplateModel timetableTemplate;

    @Override
    public String toString() {
        return "StopTimetableConfig{" +
                "route=" + route +
                ", stop=" + stop +
                ", singleTimetableData=" + singleTimetableData +
                ", timetableTemplate=" + timetableTemplate +
                '}';
    }
}

