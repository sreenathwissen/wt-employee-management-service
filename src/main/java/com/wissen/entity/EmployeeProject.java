package com.wissen.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_project")
public class EmployeeProject {
    @EmbeddedId
    EmployeeProjectId employeeProjectId;
    @Column(name = "doj_onboarding")
    Date dojOnboarding;
    @Column(name = "dor_onboarding")
    Date dorOnboarding;
}

@Embeddable
class EmployeeProjectId implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="emp_id")
    Employee employee;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="project_id")
    Project project;
}