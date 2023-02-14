package com.example.backend.repositories;

import com.example.backend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {}
