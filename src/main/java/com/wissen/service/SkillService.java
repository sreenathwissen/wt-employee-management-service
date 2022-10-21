package com.wissen.service;

import com.wissen.entity.Department;
import com.wissen.entity.Skill;

import java.util.List;

public interface SkillService {
    public List<Skill> saveSkills(final List<String> skills);
    public List<Skill> searchSkills(final String searchString);
    public List<Skill> getAllSkills();
    public Skill getSkillById(int id);
}
