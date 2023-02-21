package com.example.backend.services.impl;

import com.example.backend.entities.User;
import com.example.backend.entities.dto.UserResponseDTO;
import com.example.backend.entities.mapper.UserMapper;
import com.example.backend.repositories.UserRepository;
import com.example.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponseDTO> lisUser() {
        List<User> user = this.userRepository.findAll();
        List<UserResponseDTO> userResponseDTO = this.userMapper.convertToDtoResponseList(user);
        return userResponseDTO;
    }

    @Override
    public List<User> lisUsers() {
        return this.userRepository.findAll();
    }


}
