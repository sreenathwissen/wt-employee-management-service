package com.wissen.model.response;

import com.wissen.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeManagementResponse {

    ResponseStatus responseStatus;
    Object responseData;
    Error error;
}
