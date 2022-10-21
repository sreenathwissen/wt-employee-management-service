package com.wissen.service.impl;

import com.wissen.entity.Employee;
import com.wissen.entity.EmployeeSkill;
import com.wissen.entity.Skill;
import com.wissen.entity.key.EmployeeSkillId;
import com.wissen.repository.EmployeeSkillRepository;
import com.wissen.service.EmployeeSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    @Autowired
    private EmployeeSkillRepository employeeSkillRepository;

    @Override
    public EmployeeSkill saveEmployeeSkill(Employee employee, EmployeeSkill employeeSkill) {
        employeeSkill.getEmployeeSkillId().setEmployee(employee);
        return this.employeeSkillRepository.save(employeeSkill);
    }
}
