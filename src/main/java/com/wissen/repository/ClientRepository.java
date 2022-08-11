package com.wissen.repository;

import com.wissen.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    public Client findByCname(String name);
}
