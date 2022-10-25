package com.wissen.repository;

import com.wissen.entity.Client;
import com.wissen.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository  extends JpaRepository<Project, Integer> {

    @Query("select p from Project p inner join Client c on(p.client.clientId=c.clientId) where "
            + "p.projectName LIKE CONCAT('%',:projectName,'%')")
    public List<Project>  getProjectToClientDetails(final String projectName);

    @Query("select p from Project p inner join Client c on(p.client.clientId=c.clientId) where "
            + "p.projectId=:projectId")
    public Project getProjectToClientDetailsByProjectId(final int projectId);
}
