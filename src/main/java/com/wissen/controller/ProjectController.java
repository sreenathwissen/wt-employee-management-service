package com.wissen.controller;

import com.wissen.dto.ProjectDTO;
import com.wissen.entity.Project;
import com.wissen.repository.ProjectRepository;
import com.wissen.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/project")
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping
    public ResponseEntity<String> saveProject(@RequestBody @NotEmpty(message = "Input client list cannot be empty.") final List<@Valid ProjectDTO> projects) {
        log.info("START: Saving projects : {}", projects);
        this.projectService.saveProjects(projects);
        log.info("END: Saving projects");
        return ResponseEntity.status(HttpStatus.OK)
                .body("Saved projects successfully");
    }
}
