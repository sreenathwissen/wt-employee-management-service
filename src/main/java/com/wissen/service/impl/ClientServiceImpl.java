package com.wissen.service.impl;

import com.wissen.dto.ClientDTO;
import com.wissen.entity.Client;
import com.wissen.repository.ClientRepository;
import com.wissen.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void saveClients(final List<ClientDTO> clients) {
        List<Client> clientEntities = clients.parallelStream()
                .map(client -> getClient(client))
                .collect(Collectors.toList());

        this.clientRepository.saveAll(clientEntities);
    }

    private Client getClient(final ClientDTO client) {
        Client clientEntity = new Client();
        clientEntity.setClientName(client.getClientName());
        clientEntity.setClientLocation(client.getClientLocation());
        return clientEntity;
    }
}
