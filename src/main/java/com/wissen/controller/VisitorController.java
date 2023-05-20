package com.wissen.controller;

import com.wissen.enums.ResponseStatus;
import com.wissen.model.VisitorPointOfContactDetail;
import com.wissen.response.EmployeeManagementResponse;
import com.wissen.response.ErrorResponse;
import com.wissen.service.VisitorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee/visitor")
@Slf4j
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @GetMapping("/getPointOfContact")
    public EmployeeManagementResponse<VisitorPointOfContactDetail> getVisitorPointOfContact(@RequestParam String wissenId) {
        EmployeeManagementResponse<VisitorPointOfContactDetail> response = new EmployeeManagementResponse<>();

        try {
            this.visitorService.getPointOfContactById(wissenId, response);
        } catch (Exception e) {
            log.error("Exception : {}", e.getMessage());
            ErrorResponse error = ErrorResponse.builder()
                    .errorMessage(e.getMessage())
                    .stackTraces(e.getStackTrace())
                    .build();
            response.getResponseHeaders().getErrorResponses().add(error);
            response.getResponseHeaders().setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }

    @GetMapping("/searchPointOfContact")
    public EmployeeManagementResponse<VisitorPointOfContactDetail> searchVisitorPointOfContact(@RequestParam String search) {
        EmployeeManagementResponse<VisitorPointOfContactDetail> response = new EmployeeManagementResponse<>();

        try {
            this.visitorService.searchPointOfContactById(search, response);
        } catch (Exception e) {
            log.error("Exception : {}", e.getMessage());
            ErrorResponse error = ErrorResponse.builder()
                    .errorMessage(e.getMessage())
                    .stackTraces(e.getStackTrace())
                    .build();
            response.getResponseHeaders().getErrorResponses().add(error);
            response.getResponseHeaders().setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
