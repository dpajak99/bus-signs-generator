package com.tarbus.dto.response.company_timetable_templates;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyTimetableTemplatesResponseError implements CompanyTimetableTemplatesResponse {
    private String message = "Error";
}
