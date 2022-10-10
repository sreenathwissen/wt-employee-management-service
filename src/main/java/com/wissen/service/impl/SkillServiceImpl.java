package com.wissen.service.impl;

import com.wissen.entity.Skill;
import com.wissen.repository.SkillRespository;
import com.wissen.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    SkillRespository skillRespository;

    @Override
    public void saveSkills (final List<String> skills){
        List<Skill> skillEntities = skills.stream()
                .map(skill -> getSkill(skill))
                .collect(Collectors.toList());

        this.skillRespository.saveAll(skillEntities);
    }

    private Skill getSkill(final String skills){
        Skill skillEntity = new Skill();
        skillEntity.setSkillName(skills);

        return skillEntity;
    }
}
