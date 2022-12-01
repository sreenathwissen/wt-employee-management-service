package com.wissen.repository;

import com.wissen.entity.Employee;
import com.wissen.entity.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Integer> {

    public List<EmployeeSkill> getEmployeeSkillByEmployee(Employee employee);
}
