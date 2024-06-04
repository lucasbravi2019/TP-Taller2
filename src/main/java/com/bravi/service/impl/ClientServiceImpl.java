package com.bravi.service.impl;

import com.bravi.entity.Client;
import com.bravi.repository.Repository;
import com.bravi.service.ClientService;
import com.bravi.util.Logger;

import java.util.List;
import java.util.logging.Level;

import static com.bravi.util.Logger.log;

public class ClientServiceImpl implements ClientService {

    private final Repository<Client> repository;

    public ClientServiceImpl(Repository<Client> repository) {
        this.repository = repository;
    }

    @Override
    public void showAllClients() {
        List<Client> clients = repository.findAll();

        for (Client client : clients) {
            log("Client");
            log("ClientId: " + client.getId());
            log("Nombre: " + client.getName());
            log("Dirección: " + client.getDireccion());
        }
    }

    @Override
    public void showClientHasMoreOrders() {
        log("Showing client has more orders");
    }

    @Override
    public void showClientMoreMoneySpent() {
        log("Showing client more money spent");
    }
}
