package com.wissen.entity.key;

import com.wissen.entity.Employee;
import com.wissen.entity.Project;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class EmployeeProjectId implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="emp_id")
    Employee employee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="project_id")
    Project project;
}
