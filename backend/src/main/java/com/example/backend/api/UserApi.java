package com.example.backend.api;

import com.example.backend.entities.User;
import com.example.backend.entities.dto.UserResponseDTO;
import com.example.backend.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin("*")
public class UserApi {

    @Autowired
    private UserServiceImpl userService;


    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listUser() {
        List<UserResponseDTO> userResponseDTOS = this.userService.lisUser();
        return ResponseEntity.ok().body(userResponseDTOS);
    }

}
