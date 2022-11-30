package com.wissen.repository;

import com.wissen.entity.EmployeeSkill;
import com.wissen.entity.key.EmployeeSkillId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Integer> {
}
