package com.tarbus.models.timetable_template_content;

import com.tarbus.models.schedule.RouteModel;
import com.tarbus.models.schedule.TimetableTemplateModel;
import com.tarbus.models.timetable_data.MultiTimetableData;
import com.tarbus.models.timetable_data.SingleTimetableData;
import com.tarbus.models.timetable_data.TimetableData;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class MultiTimetableTemplateContent implements TimetableTemplateContent {
    private List<SingleTimetableData> schedules;
    private TimetableTemplateModel timetableTemplate;
    private List<RouteModel> routes;
    private MultiTimetableData timetableData;

    public MultiTimetableTemplateContent(TimetableTemplateModel timetableTemplate, List<RouteModel> routes) {
        this.timetableTemplate = timetableTemplate;
        this.routes = new ArrayList<>(routes);
        this.schedules = new ArrayList<>();
        this.timetableData = new MultiTimetableData();
    }

    public MultiTimetableTemplateContent(TimetableTemplateModel timetableTemplate, List<SingleTimetableData> schedules, List<RouteModel> routes) {
        this.timetableTemplate = timetableTemplate;
        this.routes = new ArrayList<>(routes);
        this.schedules = new ArrayList<>(schedules);
        this.timetableData = new MultiTimetableData(schedules);
    }

    public void add(SingleTimetableData stopSingleTimetableData, RouteModel routeModel) {
        schedules.add(stopSingleTimetableData);
        timetableData = new MultiTimetableData(schedules);
        routes.add(routeModel);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MultiTimetableTemplateContent that)) return false;
        return Objects.equals(schedules, that.schedules) && Objects.equals(timetableTemplate, that.timetableTemplate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schedules, timetableTemplate);
    }

    @Override
    public String toString() {
        return "MultiTemplate{" +
                "schedules=" + schedules +
                ", timetableTemplate=" + timetableTemplate +
                '}';
    }

    @Override
    public TimetableData getTimeTableData() {
        return timetableData;
    }
}