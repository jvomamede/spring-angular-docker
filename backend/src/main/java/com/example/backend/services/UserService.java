package com.example.backend.services;

import com.example.backend.entities.User;
import com.example.backend.entities.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    public List<UserResponseDTO> lisUser();

    public List<User> lisUsers();


}
