package com.tarbus.dto.response.company_timetable_templates;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CompanyTimetableTemplatesResponseImpl implements CompanyTimetableTemplatesResponse {
    @JsonProperty("timetables")
    List<CompanyTimetableTemplateDto> companyTimetableTemplateDtoList;
}
