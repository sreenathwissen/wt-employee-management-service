package com.wissen.service;

import com.wissen.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    public void saveClients(final List<ClientDTO> clients);
}
