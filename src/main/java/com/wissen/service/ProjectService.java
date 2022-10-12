package com.wissen.service;

import com.wissen.dto.ProjectDTO;

import java.time.LocalDate;
import java.util.List;

public interface ProjectService {

    public void saveProjects(final List<ProjectDTO> projects);

    public void saveProjectEmployeeMapping(final int projectId, final int employeeId, final LocalDate doj, final LocalDate dor);
}
