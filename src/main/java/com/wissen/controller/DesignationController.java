package com.wissen.controller;

import com.wissen.entity.Department;
import com.wissen.entity.Designation;
import com.wissen.service.DesignationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Validated
@RestController
@Slf4j
@RequestMapping("/api/designation")
public class DesignationController {

    @Autowired
    private DesignationService designationService;

    @PostMapping
    public ResponseEntity<String> saveDesignation(@RequestBody @NotEmpty(message = "Designation list is empty.") final List<String> designations){
        log.info("Starting to save the designations");
        this.designationService.saveDesignations(designations);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Designations are saved successfully");
    }

    @GetMapping
    public List<Designation> getAllDesignation(){
        log.info("Starting to fetch all the designations");
        return designationService.getAllDesignation();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Designation> getDesignationById(@PathVariable int id){
        return new ResponseEntity<>(designationService.getDesignationById(id),HttpStatus.OK);
    }
}
