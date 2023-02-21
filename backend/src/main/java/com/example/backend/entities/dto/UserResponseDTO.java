package com.example.backend.entities.dto;

import jakarta.persistence.Column;

public class UserResponseDTO {

    private String email;


    private String name;

    private String cpf;

    private String phone;

    public UserResponseDTO() {}

    public UserResponseDTO(String email, String name, String cpf, String phone) {
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
