package com.wissen.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * DebugInfo class.
 */
@Data
@Builder
public class DebugInfoResponse {

    private String hostName;
    private List<String> entity;
    private List<String> query;
}
