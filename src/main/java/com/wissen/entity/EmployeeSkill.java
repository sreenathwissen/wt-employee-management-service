package com.wissen.entity;

import com.wissen.enums.Levels;
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
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="emp_id")
    Employee employee;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="skill_id")
    Skill skill;
    Levels levels;
}
