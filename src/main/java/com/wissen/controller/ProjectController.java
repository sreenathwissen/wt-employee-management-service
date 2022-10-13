package com.wissen.controller;

import com.wissen.dto.ProjectDTO;
import com.wissen.entity.Project;
import com.wissen.repository.ProjectRepository;
import com.wissen.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/project")
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<String> saveProject(@RequestBody @NotEmpty(message = "Input client list cannot be empty.") final List<@Valid ProjectDTO> projects) {
        log.info("START: Saving projects : {}", projects);
        this.projectService.saveProjects(projects);
        log.info("END: Saving projects");
        return ResponseEntity.status(HttpStatus.OK)
                .body("Saved projects successfully");
    }

    @PostMapping("/projectEmployeeMapping")
    public ResponseEntity<String> saveProjectEmployeeMapping(@RequestParam @NotNull(message = "Project id is null") final int projectId,
                                                             @RequestParam @NotNull(message = "Project id is null") final int employeeId,
                                                             @RequestParam @NotNull(message = "DOJ id is null") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate doj,
                                                             @RequestParam @NotNull(message = "DOR id is null") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate dor) {
        log.info("START: Saving projects employee mapping");
        log.info("Project id : {}, Employee id : {}, DOJ : {}, DOR : {} ", projectId, employeeId, doj, dor);
        this.projectService.saveProjectEmployeeMapping(projectId, employeeId, doj, dor);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Saved project to employee mapping successfully");
    }
}
