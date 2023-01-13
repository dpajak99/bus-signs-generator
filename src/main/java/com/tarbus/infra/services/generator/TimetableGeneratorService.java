package com.tarbus.infra.services.generator;

import com.tarbus.infra.dto.request.generate_timetable_request.GenerateTimetableRequest;
import com.tarbus.infra.dto.response.generate_timetable_response.GenerateTimetableResponse;

public interface TimetableGeneratorService {
    GenerateTimetableResponse generateTimetable(GenerateTimetableRequest generateTimetableRequest);
}
