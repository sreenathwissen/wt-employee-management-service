package com.wissen.service.impl;

import com.wissen.dto.ProjectDTO;
import com.wissen.entity.Client;
import com.wissen.entity.Project;
import com.wissen.repository.ProjectRepository;
import com.wissen.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void saveProjects(List<ProjectDTO> projects) {
        List<Project> projectEntities = projects.parallelStream()
                .map(project -> getPoject(project))
                .collect(Collectors.toList());
        this.projectRepository.saveAll(projectEntities);
    }

    private Project getPoject(final ProjectDTO projectDTO) {
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
