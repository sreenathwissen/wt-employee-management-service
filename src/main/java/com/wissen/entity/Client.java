package com.wissen.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int client_id;
    String cname;
    String location;
    String remoteManager;
    String hiringManager;
    @OneToMany(mappedBy = "client",  cascade = CascadeType.ALL)
    @JsonBackReference
    Set<Employee> employees = new HashSet<>();
}
