package com.wissen.repository;

import com.wissen.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    public Client findByClientName(String name);

    @Query("SELECT c FROM Client c WHERE c.clientName LIKE CONCAT('%',:searchString, '%')")
    public List<Client> getClientByPattern(String searchString);
}
