package com.wissen.entity;

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
public class EmployeeAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    AccountDetails accountDetails;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    Client client;
}
