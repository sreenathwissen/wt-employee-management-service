package com.wissen.service;

import com.wissen.dto.EmployeeProjectDTO;
import com.wissen.dto.ProjectDTO;
import com.wissen.entity.EmployeeProject;
import com.wissen.entity.Project;
import com.wissen.exception.DataAlreadyExistException;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface class responsible project related things.
 */
public interface ProjectService {

    /**
     * Method to save projects.
     *
     * @param projects
     * @return projects
     */
    public List<Project> saveProjects(final List<ProjectDTO> projects) throws DataAlreadyExistException;

    /**
     * Method to save employee to project mapping
     *
     * @param employeeProjects
     * @return employeeProjects
     * @throws DataAlreadyExistException
     */
    public List<EmployeeProject> saveProjectEmployeeMapping(final List<EmployeeProjectDTO> employeeProjects) throws DataAlreadyExistException;

    /**
     * Method to save employee to project mapping.
     *
     * @param projectId
     * @param wissenId
     * @param doj
     * @param dor
     * @return employeeProject
     */
    public EmployeeProject saveProjectEmployeeMapping(final int projectId, final String wissenId, final LocalDate doj, final LocalDate dor);

    /**
     * Method to search project to client details mapping.
     *
     * @param searchString
     * @return projects
     */
    public List<Project> searchProjectToClientDetails(final String searchString);

    /**
     * Method to get project by project id.
     *
     * @param projectId
     * @return project
     */
    public Project getProjectToClientDetailsByProjectId(final int projectId);

    /**
     * Method to project of employee by employee id.
     *
     * @param wissenId
     * @return employeeProjects
     */
    public List<EmployeeProject> getEmployeeProjectByWissenId(String wissenId);

    /**
     * @author Vishal Tomar
     * @description Method to fetch all projects.
     * @return List of project.
     */
    public List<Project> getAllProjects();
}
