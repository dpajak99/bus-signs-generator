package com.tarbus.dto.response.update_action_response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateActionResponseImpl implements UpdateActionResponse {
    private String message = "OK";
}
