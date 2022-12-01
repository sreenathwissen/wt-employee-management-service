package com.wissen.service.impl;

import com.wissen.entity.Employee;
import com.wissen.entity.EmployeeSkill;
import com.wissen.entity.Skill;
import com.wissen.repository.EmployeeSkillRepository;
import com.wissen.service.EmployeeSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    @Autowired
    private EmployeeSkillRepository employeeSkillRepository;

    @Override
    public List<EmployeeSkill> saveEmployeeSkills(List<EmployeeSkill> employeeSkillList) {
        return this.employeeSkillRepository.saveAll(employeeSkillList);
    }

    @Override
    public EmployeeSkill saveSkillEmployeeMapping(int skillId, int employeeId, int levels) {
        final EmployeeSkill employeeSkill = new EmployeeSkill();

        Skill skill = new Skill();
        skill.setSkillId(skillId);
        Employee employee = new Employee();
        employee.setEmpId(employeeId);

        employeeSkill.setSkill(skill);
        employeeSkill.setEmployee(employee);

        employeeSkill.setLevels(levels);
        return this.employeeSkillRepository.save(employeeSkill);
    }

    @Override
    public EmployeeSkill updateSkillEmployeeMapping(int skillId, int employeeId, int employeeSkillId, int levels) {
        final EmployeeSkill employeeSkill = new EmployeeSkill();

        Skill skill = new Skill();
        skill.setSkillId(skillId);
        Employee employee = new Employee();
        employee.setEmpId(employeeId);

        employeeSkill.setSkill(skill);
        employeeSkill.setEmployee(employee);
        employeeSkill.setEmployeeSkillId(employeeSkillId);
        employeeSkill.setLevels(levels);
        return this.employeeSkillRepository.save(employeeSkill);
    }
}
