package com.wissen.repository;

import com.wissen.entity.Employee;
import com.wissen.entity.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Integer> {

    List<EmployeeProject> getEmployeeProjectByEmployee(Employee employee);
}
