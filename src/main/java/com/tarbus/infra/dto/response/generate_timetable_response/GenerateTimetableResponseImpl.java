package com.tarbus.infra.dto.response.generate_timetable_response;

import com.tarbus.models.TimetableBuilderOutput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GenerateTimetableResponseImpl implements GenerateTimetableResponse {
    private TimetableBuilderOutput timetableBuilderOutput;
}
