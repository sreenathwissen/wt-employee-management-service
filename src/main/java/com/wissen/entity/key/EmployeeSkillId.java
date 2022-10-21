package com.wissen.entity.key;

import com.wissen.entity.Employee;
import com.wissen.entity.Skill;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class EmployeeSkillId implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    Employee employee;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_id")
    Skill skill;
}
