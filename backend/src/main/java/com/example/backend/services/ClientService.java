package com.example.backend.services;

import com.example.backend.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {


    public Client updateClient(Integer id, Client client);
    public Client save(Client client);

    public List<Client> findAll();

    public void deleteById(Integer id);

    public Client findById(Integer id) throws Exception;


}
