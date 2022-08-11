package com.wissen.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int account_id;
    String accnumber;
    String bank;
    String IFSC;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    Address accountAddress;
    @OneToOne(mappedBy = "accountDetails",  cascade = CascadeType.ALL)
    @JsonBackReference
    Employee employee;
}
