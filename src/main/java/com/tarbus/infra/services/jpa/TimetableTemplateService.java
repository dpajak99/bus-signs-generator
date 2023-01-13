package com.tarbus.infra.services.jpa;

import com.tarbus.models.schedule.TimetableTemplateModel;

public interface TimetableTemplateService {
    TimetableTemplateModel getTimetableTemplateById(String id);
    TimetableTemplateModel getTimetableTemplateByRouteId(Long routeId);
}
