package com.wissen.service;

import com.wissen.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    public void saveProjects(final List<ProjectDTO> projects);
}
