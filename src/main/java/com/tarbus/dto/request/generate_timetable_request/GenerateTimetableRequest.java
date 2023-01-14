package com.tarbus.dto.request.generate_timetable_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tarbus.utils.file_naming_policy.FileNamingPolicy;
import com.tarbus.utils.file_naming_policy.FileNamingPolicyType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GenerateTimetableRequest {

    @JsonProperty("file_naming_policy")
    private FileNamingPolicyType fileNamingPolicy;

    @JsonProperty("template_id")
    private String templateId;
    
    @JsonProperty("route_config_list")
    private List<RouteConfigDto> routeConfigDtoList;

    @Override
    public String toString() {
        return "GenerateTimetableRequest{" +
                "maxTemplatesPerPage=" + fileNamingPolicy +
                ", templateId='" + templateId + '\'' +
                ", routeConfigDtoList=" + routeConfigDtoList +
                '}';
    }
}
