package com.wissen.service;

import com.wissen.dto.ProjectDTO;
import com.wissen.entity.Project;

import java.time.LocalDate;
import java.util.List;

public interface ProjectService {

    public void saveProjects(final List<ProjectDTO> projects);

    public void saveProjectEmployeeMapping(final int projectId, final int employeeId, final LocalDate doj, final LocalDate dor);

    public List<Project> searchProjectToClientDetails(final String searchString);

    public Project getProjectToClientDetailsByProjectId(final int projectId);

}
