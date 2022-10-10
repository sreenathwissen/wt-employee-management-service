package com.wissen.repository;

import com.wissen.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRespository extends JpaRepository<Skill, Integer> {
}
