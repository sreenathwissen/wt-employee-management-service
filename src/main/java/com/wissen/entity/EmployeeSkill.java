package com.wissen.entity;

import com.wissen.entity.key.EmployeeSkillId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_skill")
public class EmployeeSkill {
    @EmbeddedId
    EmployeeSkillId employeeSkillId;
    int levels;
}

