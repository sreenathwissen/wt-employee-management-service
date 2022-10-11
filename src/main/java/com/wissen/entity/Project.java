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
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    int projectId;
    @Column(name = "project_name")
    String projectName;
    @Column(name = "project_location")
    String projectLocation;
    @Column(name = "project_lead")
    String project_lead;
    @Column(name = "project_type")
    String projectType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    Client client;
}