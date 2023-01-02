package com.wissen.repository;

import com.wissen.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Client repository class.
 *
 * @author Vishal Tomar
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    /**
     * Find client by name
     *
     * @param name
     * @return client
     */
    public Client findByClientName(String name);

    /**
     * Method to get client by pattern.
     *
     * @param searchString
     * @return clients
     */
    @Query("SELECT c FROM Client c WHERE c.clientName LIKE CONCAT('%',:searchString, '%')")
    public List<Client> getClientByPattern(String searchString);
}
