package com.wissen.controller;

import com.wissen.entity.Designation;
import com.wissen.service.DesignationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Validated
@RestController
@Slf4j
@RequestMapping("/api/designation")
public class DesignationAPI {

    @Autowired
    private DesignationService designationService;

    @PostMapping
    public ResponseEntity<String> saveDesignation(@RequestBody @NotEmpty(message = "Designation list is empty.") final List<String> designations){
        log.info("Starting to save the designations");
        this.designationService.saveDesignations(designations);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Designations are saved successfully");
    }
}
