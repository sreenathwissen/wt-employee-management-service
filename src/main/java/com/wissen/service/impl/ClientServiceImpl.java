package com.wissen.service.impl;

import com.wissen.dto.ClientDTO;
import com.wissen.entity.Client;
import com.wissen.repository.ClientRepository;
import com.wissen.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation class for client related things.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Client> saveClients(final List<ClientDTO> clients) {
        List<Client> clientEntities = clients.parallelStream()
                .map(client -> getClient(client))
                .collect(Collectors.toList());

        return this.clientRepository.saveAll(clientEntities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Client> searchClients(String searchString) {
        List<Client> clients = new ArrayList<>();
        clients.addAll(this.clientRepository.getClientByPattern(searchString));
        return clients;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Client getClientById(int clientId) {
        Optional<Client> result =  this.clientRepository.findById(clientId);
        if(Objects.nonNull(result))
            return result.get();
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

    private Client getClient(final ClientDTO client) {
        Client clientEntity = new Client();
        clientEntity.setClientName(client.getClientName());
        clientEntity.setClientLocation(client.getClientLocation());
        return clientEntity;
    }
}
