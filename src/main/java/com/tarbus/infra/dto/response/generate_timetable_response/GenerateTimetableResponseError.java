package com.tarbus.infra.dto.response.generate_timetable_response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GenerateTimetableResponseError implements  GenerateTimetableResponse {
    private String message = "ERROR";
}
