package com.wissen.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_project")
public class EmployeeProject {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="emp_id")
    Employee employee;
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="project_id")
    Project project;
    @Column(name = "doj_onboarding")
    Date dojOnboarding;
    @Column(name = "dor_onboarding")
    Date dorOnboarding;
}
