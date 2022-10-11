package com.wissen.repository;

import com.wissen.entity.Client;
import com.wissen.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository  extends JpaRepository<Project, Integer> {
}
