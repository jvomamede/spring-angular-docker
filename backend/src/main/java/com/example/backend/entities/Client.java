package com.example.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;


    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "phone")
    private String phone;

    public Client() {}

    public Client(String name, String cpf, String phone) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hashCode(cpf);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Client) {
            if (((Client) obj).getCpf().equals(getCpf())) {
                return true;
            }
        }

        return false;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Integer getId() {
        return id;
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
}
