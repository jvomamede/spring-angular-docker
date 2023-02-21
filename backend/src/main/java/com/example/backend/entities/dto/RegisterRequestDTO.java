package com.example.backend.entities.dto;

import com.example.backend.enums.ProfileEnum;
import jakarta.persistence.Column;

public class RegisterRequestDTO {

    private String email;
    private String password;
    private String name;

    private String cpf;

    private String phone;
    private ProfileEnum profileEnum;

    public RegisterRequestDTO() {}

    public RegisterRequestDTO(String email, String password, ProfileEnum profileEnum, String name,
                              String cpf, String phone) {
        this.email = email;
        this.password = password;
        this.profileEnum = profileEnum;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfileEnum(ProfileEnum profileEnum) {
        this.profileEnum = profileEnum;
    }

    public ProfileEnum getProfileEnum() {
        return profileEnum;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
