package com.wissen.service.impl;

import com.wissen.entity.Skill;
import com.wissen.repository.SkillRespository;
import com.wissen.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation class for skill related things.
 */
@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    SkillRespository skillRespository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Skill> saveSkills (final List<String> skills){
        List<Skill> skillEntities = skills.stream()
                .map(skill -> getSkill(skill))
                .collect(Collectors.toList());

        return this.skillRespository.saveAll(skillEntities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Skill> searchSkills(String searchString) {
        List<Skill> skills = new ArrayList<>();
        skills.addAll(this.skillRespository.getSkillByPattern(searchString));
        return skills;
    }

    private Skill getSkill(final String skills){
        Skill skillEntity = new Skill();
        skillEntity.setSkillName(skills);

        return skillEntity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Skill> getAllSkills(){
        List<Skill> skills = new ArrayList<Skill>();
        skillRespository.findAll().forEach(skill -> skills.add(skill));
        return skills;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Skill getSkillById(int id){
        return skillRespository.findById(id).get();
    }
}
