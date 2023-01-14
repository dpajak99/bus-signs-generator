package com.tarbus.models.timetable_template_content;

import com.tarbus.models.schedule.RouteModel;
import com.tarbus.models.schedule.timetable_template_model.TimetableTemplateModel;
import com.tarbus.models.timetable_data.SingleTimetableData;
import com.tarbus.models.timetable_data.TimetableData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class SingleTimetableTemplateContent implements TimetableTemplateContent {
    private SingleTimetableData timetableData;
    private TimetableTemplateModel timetableTemplate;

    private RouteModel route;

    public SingleTimetableTemplateContent(TimetableTemplateModel timetableTemplate, SingleTimetableData timetableData, RouteModel route) {
        this.timetableTemplate = timetableTemplate;
        this.timetableData = timetableData;
        this.route = route;
    }

    @Override
    public List<RouteModel> getRoutes() {
        return List.of(route);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SingleTimetableTemplateContent that)) return false;
        return Objects.equals(timetableData, that.timetableData) && Objects.equals(timetableTemplate, that.timetableTemplate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timetableData, timetableTemplate);
    }

    @Override
    public TimetableData getTimeTableData() {
        return timetableData;
    }

    @Override
    public String toString() {
        return "SingleTemplate{" +
                "timetableData=" + timetableData +
                ", timetableTemplate=" + timetableTemplate +
                ", route=" + route +
                '}';
    }
}