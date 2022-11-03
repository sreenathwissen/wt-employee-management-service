package com.wissen.repository;

import com.wissen.entity.Employee;
import com.wissen.entity.EmployeeProject;
import com.wissen.entity.key.EmployeeProjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, EmployeeProjectId> {

    List<EmployeeProject> getEmployeeProjectByEmployeeProjectIdEmployee(Employee employee);
}
