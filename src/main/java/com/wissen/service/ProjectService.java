package com.wissen.service;

import com.wissen.dto.ProjectDTO;
import com.wissen.entity.EmployeeProject;
import com.wissen.entity.Project;

import java.time.LocalDate;
import java.util.List;

public interface ProjectService {

    public List<Project> saveProjects(final List<ProjectDTO> projects);

    public EmployeeProject saveProjectEmployeeMapping(final int projectId, final int employeeId, final LocalDate doj, final LocalDate dor);

    public List<Project> searchProjectToClientDetails(final String searchString);

    public Project getProjectToClientDetailsByProjectId(final int projectId);

    public List<EmployeeProject> getEmployeeProjectByEmployeeId(int empId);

    /**
     * @author Vishal Tomar
     * @description Method to fetch all projects.
     * @return List of project.
     */
    public List<Project> getAllProjects();
}
