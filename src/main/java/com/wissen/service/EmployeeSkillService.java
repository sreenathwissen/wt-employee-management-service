package com.wissen.service;

import com.wissen.entity.Employee;
import com.wissen.entity.EmployeeSkill;
import com.wissen.entity.Skill;

import java.util.List;

public interface EmployeeSkillService {
    public List<EmployeeSkill> saveEmployeeSkills(List<EmployeeSkill> employeeSkillList);

    public EmployeeSkill saveSkillEmployeeMapping(final int skillId, final int employeeId, final int levels);
}
