package com.tarbus.dto.response.company_timetable_templates;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CompanyTimetableTemplateDto {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("thumbnail")
    private String thumbnailUrl;
    @JsonProperty("created_at")
    private Date creationDate;
    @JsonProperty("owner_since")
    private Date ownerDate;
}
