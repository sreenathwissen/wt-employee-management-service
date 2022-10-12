package com.wissen.entity;

import com.wissen.entity.key.EmployeeProjectId;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "employee_project")
public class EmployeeProject {
    @EmbeddedId
    EmployeeProjectId employeeProjectId;
    @Column(name = "doj_onboarding")
    LocalDate dojOnboarding;
    @Column(name = "dor_onboarding")
    LocalDate dorOnboarding;
}
