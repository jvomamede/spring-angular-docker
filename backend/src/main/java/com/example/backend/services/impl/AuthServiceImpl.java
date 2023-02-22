package com.example.backend.services.impl;

import com.example.backend.entities.User;
import com.example.backend.entities.dto.AuthRequestDTO;
import com.example.backend.entities.dto.AuthResponseDTO;
import com.example.backend.entities.dto.RegisterRequestDTO;
import com.example.backend.repositories.UserRepository;
import com.example.backend.services.AuthService;
import com.example.backend.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder, JwtUtils jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public AuthResponseDTO authenticate(AuthRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        var authResponse = new AuthResponseDTO();
        authResponse.setToken(jwtToken);
        return authResponse;
    }

    public AuthResponseDTO register(RegisterRequestDTO request) {

        var user = new User();

        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(request.getRoles());
        user.setName(request.getName());
        user.setCpf(request.getCpf());
        user.setPhone(request.getPhone());

        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var authResponse = new AuthResponseDTO();
        authResponse.setToken(jwtToken);
        return authResponse;
    }

}
