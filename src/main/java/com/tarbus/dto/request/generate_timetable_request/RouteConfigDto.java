package com.tarbus.dto.request.generate_timetable_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class RouteConfigDto {
    @JsonProperty("route_id")
    private Long routeId;
}
