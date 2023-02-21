package com.example.backend.api;

import com.example.backend.entities.dto.AuthRequestDTO;
import com.example.backend.entities.dto.AuthResponseDTO;
import com.example.backend.entities.dto.RegisterRequestDTO;
import com.example.backend.services.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@CrossOrigin("*")
public class AuthApi {

    @Autowired
    private AuthServiceImpl authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(
            @RequestBody RegisterRequestDTO request
    ) {
        AuthResponseDTO response = this.authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponseDTO> authenticate(
            @RequestBody AuthRequestDTO request
    ) {
        AuthResponseDTO response = this.authService.authenticate(request);
        return ResponseEntity.ok(response);
    }

}
