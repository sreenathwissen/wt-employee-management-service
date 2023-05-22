package com.wissen.response;

import lombok.Builder;
import lombok.Data;

/**
 * Response class for error.
 *
 * @author Vishal Tomar
 */
@Data
@Builder
public class ErrorResponse {

    private String errorMessage;
    private String field;
    private StackTraceElement[] stackTraces;
}
