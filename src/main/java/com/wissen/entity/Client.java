package com.wissen.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    int clientId;
    @Column(name = "client_name")
    String clientName;
    @Column(name = "client_location")
    String clientLocation;
}
