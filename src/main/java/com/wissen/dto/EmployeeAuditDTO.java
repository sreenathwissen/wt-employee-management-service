package com.wissen.dto;

import com.wissen.entity.Client;
import com.wissen.entity.EmployeeAudit;
import lombok.*;

@Data
@NoArgsConstructor
public class EmployeeAuditDTO {
    int id;
    String email;
    String firstName;
    String pan;
    String lastName;
    String dateOfJoining;
    double yearExperience;
    String manager;
    boolean active;
    int role;
    int designation;
    Client client;
    public EmployeeAuditDTO(EmployeeAudit employee){
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.pan = employee.getPan();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.dateOfJoining = employee.getDateOfJoining();
        this.yearExperience = employee.getYearExperience();
        this.manager = employee.getManager();
        this.active = employee.isActive();
        this.role = employee.getRole();
        this.designation = employee.getDesignation();
        this.client = employee.getClient();
    }
}
