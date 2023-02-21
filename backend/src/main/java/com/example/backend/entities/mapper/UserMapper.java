package com.example.backend.entities.mapper;

import com.example.backend.entities.User;
import com.example.backend.entities.dto.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public List<UserResponseDTO> convertToDtoResponseList(List<User> userList) {
        List<UserResponseDTO> userResponseDTO = new ArrayList<UserResponseDTO>();

        for (User user : userList) {
            UserResponseDTO userResponse = modelMapper.map(user, UserResponseDTO.class);
            userResponseDTO.add(userResponse);
        }

        return userResponseDTO;
    }


}
