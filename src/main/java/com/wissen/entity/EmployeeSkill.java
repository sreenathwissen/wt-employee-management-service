package com.wissen.entity;

import com.wissen.enums.Levels;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_skill")
public class EmployeeSkill {
    @EmbeddedId
    EmployeeSkillId employeeSkillId;
    Levels levels;
}

@Embeddable
class EmployeeSkillId implements Serializable{
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="emp_id")
    Employee employee;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="skill_id")
    Skill skill;
}