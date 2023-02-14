package com.example.backend.security.auth;

public class AuthRequest {

    private String email;
    private String password;

    public AuthRequest() {}

    public AuthRequest(String email, String password) {
        this.password = password;
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
