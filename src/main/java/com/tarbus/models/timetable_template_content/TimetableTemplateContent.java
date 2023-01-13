package com.tarbus.models.timetable_template_content;

import com.tarbus.models.schedule.RouteModel;
import com.tarbus.models.schedule.TimetableTemplateModel;
import com.tarbus.models.timetable_data.TimetableData;

import java.util.List;

public interface TimetableTemplateContent {
    TimetableTemplateModel getTimetableTemplate();

    List<RouteModel> getRoutes();

    TimetableData getTimeTableData();
}
