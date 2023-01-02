package com.wissen.service.impl;

import com.wissen.dto.ProjectDTO;
import com.wissen.entity.Client;
import com.wissen.entity.Employee;
import com.wissen.entity.EmployeeProject;
import com.wissen.entity.Project;
import com.wissen.repository.EmployeeProjectRepository;
import com.wissen.repository.ProjectRepository;
import com.wissen.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation class for project related things.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Project> saveProjects(List<ProjectDTO> projects) {
        List<Project> projectEntities = projects.parallelStream()
                .map(project -> getProject(project))
                .collect(Collectors.toList());
        return this.projectRepository.saveAll(projectEntities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeProject saveProjectEmployeeMapping(int projectId, int employeeId, final LocalDate doj, final LocalDate dor) {
        final EmployeeProject employeeProject = new EmployeeProject();

        Project project = new Project();
        project.setProjectId(projectId);
        Employee employee = new Employee();
        employee.setEmpId(employeeId);

        employeeProject.setProject(project);
        employeeProject.setEmployee(employee);

        employeeProject.setDojOnboarding(doj);
        employeeProject.setDorOnboarding(dor);
        return this.employeeProjectRepository.save(employeeProject);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Project> searchProjectToClientDetails(String searchString) {
        return this.projectRepository.getProjectToClientDetails(searchString);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Project getProjectToClientDetailsByProjectId(int projectId) {
        return this.projectRepository.getProjectToClientDetailsByProjectId(projectId);
    }

    /**
     * @author Vishal Tomar
     * @description Method to fetch all projects.
     * @return List of project.
     */
    @Override
    public List<Project> getAllProjects() {
        return this.projectRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EmployeeProject> getEmployeeProjectByEmployeeId(int empId) {
        Employee employee = new Employee();
        employee.setEmpId(empId);
        return this.employeeProjectRepository.getEmployeeProjectByEmployee(employee);
    }

    private Project getProject(final ProjectDTO projectDTO) {
        Project project = new Project();
        project.setProjectName(projectDTO.getProjectName());
        project.setProjectLocation(projectDTO.getProjectLocation());
        project.setProjectLead(projectDTO.getProjectLead());
        project.setProjectType(projectDTO.getProjectType());
        Client client = new Client();
        client.setClientId(projectDTO.getClientId());
        project.setClient(client);
        return project;
    }
}
