package com.wissen.entity;

import com.wissen.dto.EmployeeDTO;
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
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String firstName;
    String pan;
    String lastName;
    String email;
    String dateOfJoining;
    double yearExperience;
    String manager;
    boolean active;
    int role;
    int designation;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    Client client;
    public Employee(EmployeeDTO employee){
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
