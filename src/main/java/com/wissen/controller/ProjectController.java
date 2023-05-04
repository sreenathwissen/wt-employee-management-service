package com.wissen.controller;

import com.wissen.dto.EmployeeProjectDTO;
import com.wissen.dto.ProjectDTO;
import com.wissen.entity.EmployeeProject;
import com.wissen.entity.Project;
import com.wissen.enums.ProjectType;
import com.wissen.enums.ResponseStatus;
import com.wissen.model.response.EmployeeManagementResponse;
import com.wissen.service.ProjectService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/project")
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<List<Project>> saveProject(@RequestBody @NotEmpty(message = "Input client list cannot be empty.") final List<@Valid ProjectDTO> projects) {
        log.info("START: Saving projects : {}", projects);
        List<Project> savedData = this.projectService.saveProjects(projects);
        log.info("END: Saving projects");
        return ResponseEntity.status(HttpStatus.OK)
                .body(savedData);
    }

    /**
     * @author Anushka Saxena
     * @param employeeProjects
     * @return employeeProjects
     */
    @PostMapping("/projectEmployeeMapping")
    public EmployeeManagementResponse saveProjectEmployeeMapping(@RequestBody @NotEmpty(message = "Employee Project cannot be empty") final List<@Valid EmployeeProjectDTO> employeeProjects) {
        log.info("START: Saving Employee Projects : {}", employeeProjects);
        List<EmployeeProject> savedData = this.projectService.saveProjectEmployeeMapping(employeeProjects);
        log.info("END: Saving employee projects");
        return EmployeeManagementResponse.builder()
                .responseStatus(ResponseStatus.SUCCESS)
                .responseData(savedData)
                .build();
    }


    @GetMapping("/search")
    public ResponseEntity<List<Project>> searchProject(@RequestParam final String searchString) {
        log.info("START :  Searching project");
        List<Project> projects = this.projectService.searchProjectToClientDetails(searchString);
        log.info("START :  Searching project");
        return ResponseEntity.status(HttpStatus.OK)
                .body(projects);
    }

    @GetMapping
    public ResponseEntity<Project> getProjectById(@RequestParam @NotNull(message = "Project id is null") final int id) {
        log.info("START :  Getting project");
        Project project = this.projectService.getProjectToClientDetailsByProjectId(id);
        log.info("START :  Getting project");
        return ResponseEntity.status(HttpStatus.OK)
                .body(project);
    }

    @GetMapping("/allProjects")
    public ResponseEntity<List<Project>> getAllProject() {
        log.info("START :  Getting all project");
        List<Project> projects = this.projectService.getAllProjects();
        log.info("END :  Getting all project");
        return ResponseEntity.status(HttpStatus.OK)
                .body(projects);
    }

    @GetMapping("/employee")
    @ApiOperation("Get employee's projects")
    public ResponseEntity<List<EmployeeProject>> getEmployeeProjectByEmployee(
            @RequestParam @NotNull(message = "Employee id is null") String wissenId
    ) {
        log.info("START : Getting employee's projects");
        List<EmployeeProject> employeeProjects = this.projectService.getEmployeeProjectByWissenId(wissenId);
        log.info("END : Getting employee's projects");
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeProjects);
    }

    /**
     * @author Vishal Tomar
     * @description Method to fetch projectType.
     * @return Enum ProjectType
     */
    @GetMapping("/projectType")
    public ResponseEntity<ProjectType[]> getProjectType(){
        return ResponseEntity.status(HttpStatus.OK).body(ProjectType.values());
    }
}
