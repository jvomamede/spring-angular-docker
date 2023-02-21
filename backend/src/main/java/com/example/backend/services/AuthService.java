package com.example.backend.services;

import com.example.backend.entities.dto.AuthRequestDTO;
import com.example.backend.entities.dto.AuthResponseDTO;
import com.example.backend.entities.dto.RegisterRequestDTO;

public interface AuthService {

    public AuthResponseDTO authenticate(AuthRequestDTO requestDTO);

    public AuthResponseDTO register(RegisterRequestDTO requestDTO);

}
