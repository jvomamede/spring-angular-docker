package com.example.backend.api;

import com.example.backend.security.auth.AuthRequest;
import com.example.backend.security.auth.AuthResponse;
import com.example.backend.security.auth.AuthService;
import com.example.backend.security.auth.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@CrossOrigin("*")
public class AuthApi {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request
    ) {
        AuthResponse response = this.authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest request
    ) {
        AuthResponse response = this.authService.authenticate(request);
        return ResponseEntity.ok(response);
    }

}
