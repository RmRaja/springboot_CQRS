package com.userws.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @NotNull(message = "Name is required")
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Size(max = 50)
    @NotNull(message = "Email is required")
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Size(max = 255)
    @NotNull(message = "Password is required")
    @Column(name = "password", nullable = false)
    private String password;

}