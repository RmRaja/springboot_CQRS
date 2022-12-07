package com.userws.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.userws.entities.User} entity
 */
public record UserDto(Long id, @Size(max = 50) @NotNull(message = "Name is required") String name,
                      @Size(max = 50) @NotNull(message = "Email is required") String email,
                      @Size(max = 255) @NotNull(message = "Password is required") String password) implements Serializable {
}