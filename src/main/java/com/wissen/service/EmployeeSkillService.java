package com.wissen.service;

import com.wissen.entity.Employee;
import com.wissen.entity.EmployeeSkill;
import com.wissen.entity.Skill;

public interface EmployeeSkillService {
    public EmployeeSkill saveEmployeeSkill(Employee employee, EmployeeSkill employeeSkill);
}
