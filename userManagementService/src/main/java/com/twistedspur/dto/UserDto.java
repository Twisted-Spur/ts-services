package com.twistedspur.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * DTO for {@link com.twistedspur.entity.User}
 */
public record UserDto(Integer id, @NotNull String firstName, @NotNull String lastName, @NotNull String email,
                      @NotNull String passwd, @NotNull LocalDate birthday, @NotNull String phoneNumber,
                      Instant createdAt, Instant updatedAt) implements Serializable {
}