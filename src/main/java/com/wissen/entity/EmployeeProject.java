package com.wissen.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "employee_project")
public class EmployeeProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_project_id")
    int employeeProjectId;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "doj_onboarding")
    LocalDate dojOnboarding;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "dor_onboarding")
    LocalDate dorOnboarding;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="emp_id")
    Employee employee;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="project_id")
    Project project;
}
