package com.wissen.service;

import com.wissen.dto.ClientDTO;
import com.wissen.entity.Client;

import java.util.List;

public interface ClientService {

    public List<Client> saveClients(final List<ClientDTO> clients);

    public List<Client> searchClients(final String searchString);

    public Client getClientById(final int clientId);

    /**
     * @author Vishal Tomar
     * @description Method to fetch all clients.
     * @return List of clients.
     */
    public List<Client> getAllClients();
}
