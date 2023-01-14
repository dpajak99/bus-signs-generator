package com.tarbus.models.timetable_template_content;

import com.tarbus.models.schedule.RouteModel;
import com.tarbus.models.schedule.timetable_template_model.TimetableTemplateModel;
import com.tarbus.models.timetable_data.TimetableData;

import java.util.List;

public interface TimetableTemplateContent {
    TimetableTemplateModel getTimetableTemplate();

    List<RouteModel> getRoutes();

    TimetableData getTimeTableData();
}
