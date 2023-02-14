package com.example.backend.services.impl;

import com.example.backend.entities.Client;
import com.example.backend.repositories.ClientRepository;
import com.example.backend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client updateClient(Integer id, Client client) {

        Client clientResponse = this.clientRepository.findById(id).get();
        clientResponse.setCpf(client.getCpf());
        clientResponse.setPhone(client.getPhone());
        clientResponse.setName(client.getName());

        this.clientRepository.save(clientResponse);
        return clientResponse;

    }

    @Override
    public Client save(Client client) {

        return this.clientRepository.save(client);
    }
    @Override
    public List<Client> findAll() {

        return this.clientRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        this.clientRepository.deleteById(id);
    }
    @Override
    public Client findById(Integer id) throws Exception {
        Optional<Client> optional = this.clientRepository.findById(id);
        return optional.orElseThrow(() -> new Exception("Não existe cliente com id: " + id));
    }

}
