package com.wissen.response;

import com.wissen.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Response header class.
 *
 * @author Vishal Tomar
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseHeader {

    private List<ErrorResponse> errorResponses = new ArrayList<>();
    private List<DebugInfoResponse> debugInfoResponseList = new ArrayList<>();
    private ResponseStatus responseStatus;
}
