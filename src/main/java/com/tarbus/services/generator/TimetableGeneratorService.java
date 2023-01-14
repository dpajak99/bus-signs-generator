package com.tarbus.services.generator;

import com.tarbus.dto.request.generate_timetable_request.GenerateTimetableRequest;
import com.tarbus.dto.response.generate_timetable_response.GenerateTimetableResponse;

public interface TimetableGeneratorService {
    GenerateTimetableResponse generateTimetable(GenerateTimetableRequest generateTimetableRequest);
}
