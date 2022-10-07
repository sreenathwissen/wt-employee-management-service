package com.wissen.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wissen.dto.EmployeeDTO;
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
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    int empId;
    @Column(name = "first_name")
    String firstName;
    String gender;
    Date dob;
    @Column(name = "blood_group")
    String bloodGroup;
    @Column(name = "primary_phone_number")
    long primaryPhoneNumber;
    @Column(name = "secondary_phone_number")
    long secondaryPhoneNumber;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "work_phone")
    long workPhone;
    @Column(name = "primary_emergency_contact_number")
    long primaryEmergencyContactNumber;
    @Column(name = "secondary_emergency_contact_number")
    long secondaryEmergencyContactNumber;
    @Column(name = "marital_status_date")
    Date maritalStatusDate;
    String email;
    Date doj;
    @Column(name = "exp_doj")
    String expDoj;
    @Column(name = "exit_date")
    Date exitDate;
    String type;
    @Column(name = "joining_location")
    String joiningLocation;
    String status;
    String manager;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="desg_id")
    Designation designation;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="dep_id")
    Department department;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="role_id")
    Role role;
    public Employee(EmployeeDTO employee){

    }
}
