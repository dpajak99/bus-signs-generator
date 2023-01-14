package com.tarbus.dto.response.generate_timetable_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tarbus.models.TimetableBuilderOutput;
import com.tarbus.models.TimetablePdfBuilderResult;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GenerateTimetableResponseImpl implements GenerateTimetableResponse {
    @JsonProperty("single")
    private List<TimetablePdfBuilderResult> singleFiles;
    @JsonProperty("shared")
    private List<TimetablePdfBuilderResult> sharedFiles;
}
