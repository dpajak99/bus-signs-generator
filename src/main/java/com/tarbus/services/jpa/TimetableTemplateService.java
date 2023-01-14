package com.tarbus.services.jpa;

import com.tarbus.models.schedule.timetable_template_model.TimetableTemplateModel;

public interface TimetableTemplateService {
    TimetableTemplateModel getTimetableTemplateById(String id);
    TimetableTemplateModel getTimetableTemplateByRouteId(Long routeId);
    TimetableTemplateModel getTimetableTemplateByCompanyId(Long companyId);
}
