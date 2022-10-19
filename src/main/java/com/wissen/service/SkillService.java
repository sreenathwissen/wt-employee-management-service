package com.wissen.service;

import com.wissen.entity.Skill;

import java.util.List;

public interface SkillService {
    public void saveSkills(final List<String> skills);
    public List<Skill> getAllSkills();
    public Skill getSkillById(int id);
}
